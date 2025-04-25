package com.mangopuree.vendor.dto;

import com.mangopuree.support.grid.dto.RequestGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "거래처 그리드 조건 DTO")
public class VendorSearchDto extends RequestGridDto {

    @Schema(description = "거래처명", example = "오박 식품")
    private String vendorName;
    @Schema(description = "대표자명", example = "권영식")
    private String representativeName;
}
