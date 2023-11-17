package com.example.jsgamesbackendmain.Model.DTO.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailCodeRequestDTO {
    private String email;
    private String Code;
}
