package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserSaveSmallBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.TokenException;
import com.example.jsgamesbackendmain.Converter.TokenConverter;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Token.AccessTokenDTO;
import com.example.jsgamesbackendmain.Model.DTO.Token.RefreshTokenDTO;
import com.example.jsgamesbackendmain.Model.DTO.Token.TokenResponseDTO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class TokenService {
    private final SecretKey key;
    private final UserRepository userRepository;

    private final UserGetByIdSmallBean userGetByIdSmallBean;

    private final UserSaveSmallBean userSaveSmallBean;

    public static final int ACCESS_TOKEN_EXPIRED_TIME = 60 * 60 * 2 * 1000; // 2 hours
    public static final int REFRESH_TOKEN_EXPIRED_TIME = 60 * 60 * 24 * 14 * 1000; // 14 days


    public TokenResponseDTO isValidToken(String userId) {

        // 토큰 가져오기
        String accessToken = getToken("accessToken");

        // 토큰 유효성 검사 (서명키)
        AccessTokenDTO accessTokenDTO = TokenConverter.parseAccessToken(accessToken, key);

        // 토큰 유효성 검사 (userId)

        if (!accessTokenDTO.isMatchUserId(userId)) {
            throw new TokenException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        // 토큰 유효성 검사 (만료)
        if (accessTokenDTO.isExpired()) {
            throw new TokenException("토큰이 만료되었습니다.");
        }

        // Refresh Token 가져오기
        String storedRefreshToken = userGetByIdSmallBean.exec(userId).getRefreshToken();
        RefreshTokenDTO refreshTokenDTO = TokenConverter.parseRefreshToken(storedRefreshToken, key);

        return TokenConverter.createTokenResponseDTO(accessTokenDTO, refreshTokenDTO);
    }

    public TokenResponseDTO createToken(String userId) {
        // Access Token, Refresh Token 생성
        AccessTokenDTO accessToken = createAccessToken(userId);
        RefreshTokenDTO refreshToken = createRefreshToken(userId);

        // DB에 저장
        UserDAO findUser = userGetByIdSmallBean.exec(userId);
        findUser.setRefreshToken(refreshToken);
        userSaveSmallBean.exec(findUser);

        // Response
        return TokenConverter.createTokenResponseDTO(accessToken, refreshToken);
    }


    private RefreshTokenDTO createRefreshToken(String userId) {
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + REFRESH_TOKEN_EXPIRED_TIME);

        String token = generateToken(userId, now, expiredDate);

        return TokenConverter.createRefreshTokenDTO(userId, token, now, expiredDate);
    }

    private AccessTokenDTO createAccessToken(String userId) {
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + ACCESS_TOKEN_EXPIRED_TIME);

        String token = generateToken(userId, now, expiredDate);
        return TokenConverter.createAccessTokenDTO(userId, token, now, expiredDate);
    }

    private String generateToken(String userId, Date now, Date expiredDate) {
        return Jwts.builder()
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(expiredDate)
                .signWith(key)
                .compact();// payload
    }

    // Get Token
    private String getToken(String tokenName) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();

        String token = request.getHeader(tokenName);

        if (token == null) {
            throw new TokenException("토큰 입력은 필수입니다.");
        }

        return token;
    }

    public TokenService(
            @Value("${jwt.secret}") String secret,
            UserRepository userRepository,
            UserGetByIdSmallBean userGetByIdSmallBean,
            UserSaveSmallBean userSaveSmallBean
    ) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.userRepository = userRepository;
        this.userGetByIdSmallBean = userGetByIdSmallBean;
        this.userSaveSmallBean = userSaveSmallBean;
    }
}
