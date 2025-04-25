package com.mangopuree.estimate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.grid.dto.ResponseGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "견적서 그리드 조회 DTO")
public class EstimateGridDto extends ResponseGridDto {

    @Schema(description = "사업자명", example = "망고퓨레 본사")
    private String businessName;

    @Schema(description = "견적일자", example = "2025-04-26")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate estimateDate;

    @Schema(description = "견적서아이디", example = "EST25041900001")
    private String estimateId;

    @Schema(description = "상태코드", example = "ESS003")
    private String estimateStatusCd;

    @Schema(description = "상태코드명", example = "확정")
    private String estimateStatusCdName;

    @Schema(description = "거래처명", example = "이이 식품5")
    private String vendorName;

    @Schema(description = "담당자명", example = "김동균5")
    private String managerName;

    @Schema(description = "유효기간코드명", example = "60일")
    private String validDateCdName;

    @Schema(description = "품목아이디", example = "FOOD000005")
    private String itemId;

    @Schema(description = "품목명", example = "참기름")
    private String itemName;

    @Schema(description = "납기일자", example = "2025-04-10")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @Schema(description = "단가", example = "8500")
    private Integer price;

    @Schema(description = "수량", example = "55")
    private Integer quantity;

    @Schema(description = "공급가액", example = "467500")
    private Integer supplyAmount;

    @Schema(description = "부가세", example = "46750")
    private Integer vatAmount;

    @Schema(description = "총액", example = "514250")
    private Integer totalAmount;

    @Schema(description = "등록자명", example = "관리자")
    private String regUsername;

    @Schema(description = "등록일시", example = "2025-04-23 03:02:11")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
