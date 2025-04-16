package com.mangopuree.item.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.base.dto.ResponseGridDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
