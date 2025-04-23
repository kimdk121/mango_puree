package com.mangopuree.vendor.dto;

import com.mangopuree.support.grid.dto.ResponseGridDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorGridDto extends ResponseGridDto {

    private Long vendorId;
    private String vendorName;
    private String representativeName;
    private String registrationNumber;
    private String address;
    private String telNo;
    private String faxNo;
    private String businessType;
    private String industryType;
}
