package com.mangopuree.business.dto;

import com.mangopuree.support.grid.dto.RequestGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "사업자 그리드 조건 DTO")
public class BusinessSearchDto extends RequestGridDto {

    @Schema(description = "상호명", example = "망고퓨레 본사")
    private String businessName;
    @Schema(description = "대표자명", example = "김동균")
    private String representativeName;
}
