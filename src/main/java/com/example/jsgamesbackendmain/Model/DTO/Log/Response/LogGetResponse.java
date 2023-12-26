package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import lombok.Getter;

import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public class LogGetResponse {
    private Long logId;
    private Long gameId;
    private Double gameScore;
}