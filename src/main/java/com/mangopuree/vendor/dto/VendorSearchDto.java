package com.mangopuree.vendor.dto;

import com.mangopuree.support.base.dto.RequestGridDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorSearchDto extends RequestGridDto {

    private String vendorName;
    private String representativeName;
}
