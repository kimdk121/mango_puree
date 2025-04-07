package com.mangopuree.item.dto;

import com.mangopuree.support.base.dto.ResponseGridDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemGridDto extends ResponseGridDto {

    private String itemId;
    private String itemName;
    private String unitCd;
    private String unitCdName;
    private String standardPrice;
    private String regId;
    private String regUsername;
    private String regDt;
}
