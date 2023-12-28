package com.example.jsgamesbackendmain.Model.DTO.Email;

import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailCodeRequestDTO {
    private String email;
    private String Code;

    public static EmailCodeRequestDTO of(UserSignUpRequestDTO userSignUpRequestDTO) {
        return EmailCodeRequestDTO.builder()
                .email(userSignUpRequestDTO.getEmail())
                .Code(userSignUpRequestDTO.getCode())
                .build();
    }
}
