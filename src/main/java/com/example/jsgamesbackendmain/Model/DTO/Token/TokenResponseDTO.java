package com.example.jsgamesbackendmain.Model.DTO.Token;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenResponseDTO {
    String accessToken;
    String refreshToken;
}
