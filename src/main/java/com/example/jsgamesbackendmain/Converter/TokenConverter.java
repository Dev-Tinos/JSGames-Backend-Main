package com.example.jsgamesbackendmain.Converter;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.TokenException;
import com.example.jsgamesbackendmain.Model.DTO.Token.AccessTokenDTO;
import com.example.jsgamesbackendmain.Model.DTO.Token.RefreshTokenDTO;
import com.example.jsgamesbackendmain.Model.DTO.Token.TokenResponseDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

public class TokenConverter {


    public static AccessTokenDTO createAccessTokenDTO(
            String userId,
            String accessToken,
            Date now,
            Date expiredDate
    ) {
        return AccessTokenDTO.builder()
                .userId(userId)
                .accessToken(accessToken)
                .issuedAt(now)
                .expiredAt(expiredDate)
                .build();
    }

    public static RefreshTokenDTO createRefreshTokenDTO(
            String userId,
            String refreshToken,
            Date now,
            Date expiredDate
    ) {
        return RefreshTokenDTO.builder()
                .userId(userId)
                .refreshToken(refreshToken)
                .issuedAt(now)
                .expiredAt(expiredDate)
                .build();
    }

    public static TokenResponseDTO createTokenResponseDTO(
            AccessTokenDTO accessTokenDTO,
            RefreshTokenDTO refreshTokenDTO
    ) {
        return TokenResponseDTO.builder()
                .accessToken(accessTokenDTO.getAccessToken())
                .refreshToken(refreshTokenDTO.getRefreshToken())
                .build();
    }

    public static AccessTokenDTO parseAccessToken(String accessToken, SecretKey key) {
        Claims body = isTokenValidByKey(accessToken, key);

        Date issuedAt = body.getIssuedAt();
        Date expiredDate = body.getExpiration();
        String userId = body.get("userId", String.class);
        return createAccessTokenDTO(userId, accessToken, issuedAt, expiredDate);
    }

    public static RefreshTokenDTO parseRefreshToken(String refreshToken, SecretKey key) {
        Claims body = isTokenValidByKey(refreshToken, key);

        Date issuedAt = body.getIssuedAt();
        Date expiredDate = body.getExpiration();
        String userId = body.get("userId", String.class);
        return createRefreshTokenDTO(userId, refreshToken, issuedAt, expiredDate);
    }

    // 토큰 파싱 및 검증
    private static Claims isTokenValidByKey(String token, SecretKey key) {
        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();

        Jws<Claims> jws;
        try {
            jws = parser.parseClaimsJws(token);
        } catch (Exception e) {
            throw new TokenException("토큰이 유효하지 않습니다.");
        }

        return jws.getBody();
    }
}
