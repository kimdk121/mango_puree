package com.mangopuree.nvrschedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.base.dto.BaseAuditDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class NvrScheduleDetailDto extends BaseAuditDto {

    @Schema(description = "카메라", example = "CAMERA0002 / 2번카메라")
    private String camera;

    @Schema(description = "서버아이디", example = "SERVER0001")
    private String serverId;

    @Schema(description = "카메라 등록일시", example = "2025-04-12 02:31:16")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cameraRegDt;

    @Schema(description = "스케쥴명", example = "스케쥴1")
    private String scheduleName;

    @Schema(description = "시작일자", example = "2025-04-18")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Schema(description = "종료일자", example = "2025-04-19")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Schema(description = "주기 (분)", example = "60")
    private int cycle;

    @Schema(description = "길이 (분)", example = "5")
    private int duration;

    @Schema(description = "마지막 다운로드일시", example = "2025-04-19 21:49:15")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastDownloadDt;

}
