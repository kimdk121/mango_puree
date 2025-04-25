package com.mangopuree.item.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.grid.dto.ResponseGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "품목 그리드 조회 DTO")
public class ItemGridDto extends ResponseGridDto {

    @Schema(description = "품목아이디", example = "FOOD000001")
    private String itemId;

    @Schema(description = "품목명", example = "김치")
    private String itemName;

    @Schema(description = "단위", example = "UNT001")
    private String unitCd;

    @Schema(description = "단위명", example = "개")
    private String unitCdName;

    @Schema(description = "표준단가", example = "7000")
    private String standardPrice;

    @Schema(description = "등록자아이디", example = "1")
    private String regId;

    @Schema(description = "등록자명", example = "관리자")
    private String regUsername;

    @Schema(description = "등록일자", example = "2025-01-05 07:21:46")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
