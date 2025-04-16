package com.mangopuree.support.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ExternalRequestDto {

    private String requestId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime requestDt;
    private String requestServer;

    public ExternalRequestDto() {
        this.requestId = UUID.randomUUID().toString();
        this.requestDt = LocalDateTime.now();
        this.requestServer = "MangoPuree";
    }
}
