package com.mangopuree.nvrserver.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "NVR 서버 조회 DTO")
public class NvrServerDto {

    @Schema(description = "서버아이디", example = "SERVER0001")
    private String serverId;

    @Schema(description = "서버명", example = "NVR영상수집서버")
    private String serverName;

    @Schema(description = "서버주소", example = "https://2bb6abf4-eb24-4b51-a489-3efcf57ef075.mock.pstmn.io")
    private String serverAddress;

    @Schema(description = "등록일시", example = "2025-04-12 02:28:39")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
