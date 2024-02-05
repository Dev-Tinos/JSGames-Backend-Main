package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Token.TokenResponseDTO;
import com.example.jsgamesbackendmain.Service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;

    @Operation(
            summary = "토큰 발급 Test API"
            , description = "userId 입력"
    )
    @GetMapping("/{userId}")
    public TokenResponseDTO createToken(
            @PathVariable String userId
    ) {
        return tokenService.createToken(userId);
    }

    @Operation(
            summary = "토큰 검증 Test API"
            , description = "Header에 accessToken 필요. path variable로 조회할 userId를 입력"
            , security = @SecurityRequirement(name = "accessToken")
    )
    @GetMapping("/isValid/{userId}")
    public TokenResponseDTO isValidToken(
            @PathVariable String userId
    ) {
        return tokenService.isValidToken(userId);
    }
}
