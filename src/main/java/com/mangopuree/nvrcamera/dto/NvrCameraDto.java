package com.mangopuree.nvrcamera.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "NVR 카메라 조회 DTO")
public class NvrCameraDto {

    @Schema(description = "카메라아이디", example = "CAMERA0001")
    private String cameraId;

    @Schema(description = "서버아이디", example = "SERVER0001")
    private String serverId;

    @Schema(description = "카메라명", example = "1번카메라")
    private String cameraName;

    @Schema(description = "등록일시", example = "2025-04-12 02:31:16")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
