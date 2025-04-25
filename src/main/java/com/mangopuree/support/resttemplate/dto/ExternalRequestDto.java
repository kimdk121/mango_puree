package com.mangopuree.support.resttemplate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Schema(description = "RestTemplate 요청 DTO")
public class ExternalRequestDto {

    @Schema(description = "요청아이디", example = "d991f060-53ac-4c30-9216-1f4e838aeacb")
    private String requestId;

    @Schema(description = "요청일시", example = "2025-04-21 09:05:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime requestDt;

    @Schema(description = "요청서버", example = "localhost:8080")
    private String requestServer;

    public ExternalRequestDto() {
        this.requestId = UUID.randomUUID().toString();
        this.requestDt = LocalDateTime.now();
        this.requestServer = "MangoPuree";
    }
}
