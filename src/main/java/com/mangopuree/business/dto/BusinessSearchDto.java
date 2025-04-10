package com.mangopuree.business.dto;

import com.mangopuree.support.base.dto.RequestGridDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessSearchDto extends RequestGridDto {

    private String businessName;
    private String representativeName;
}
