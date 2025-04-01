package com.mangopuree.business.dto;

import com.mangopuree.support.base.dto.ResponseGridDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessGridDto extends ResponseGridDto {

    private Long businessId;
    private String businessName;
    private String representativeName;
    private String registrationNumber;
    private String address;
    private String telNo;
    private String faxNo;
    private String businessType;
    private String industryType;
}
