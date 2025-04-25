package com.mangopuree.item.dto;

import com.mangopuree.support.grid.dto.RequestGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "품목 그리드 조건 DTO")
public class ItemSearchDto extends RequestGridDto {

    @Schema(description = "품목아이디", example = "FOOD000001")
    private String itemId;

    @Schema(description = "품목명", example = "김치")
    private String itemName;
}
