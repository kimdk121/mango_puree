package com.mangopuree.item.dto;

import com.mangopuree.support.base.dto.RequestGridDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchDto extends RequestGridDto {

    private String itemId;
    private String itemName;
}
