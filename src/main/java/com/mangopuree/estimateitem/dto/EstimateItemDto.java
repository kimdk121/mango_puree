package com.mangopuree.estimateitem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.base.dto.BaseAuditDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class EstimateItemDto extends BaseAuditDto {

    @Schema(description = "견적서아이디", example = "EST25040700010")
    private String estimateId;
    
    @Schema(description = "품목아이디", example = "FOOD000004")
    private String itemId;
    
    @Schema(description = "품목명", example = "간장")
    private String itemName;
    
    @Schema(description = "단위코드", example = "UNT001")
    private String unitCd;

    @Schema(description = "단위코드명", example = "개")
    private String unitCdName;

    @Schema(description = "납기일자", example = "2025-04-16")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @Schema(description = "단가", example = "7800")
    private Integer price;

    @Schema(description = "수량", example = "60")
    private Integer quantity;

    @Schema(description = "공급가액", example = "468000")
    private Integer supplyAmount;

    @Schema(description = "부가세", example = "46800")
    private Integer vatAmount;

    @Schema(description = "총액", example = "514800")
    private Integer totalAmount;
}
