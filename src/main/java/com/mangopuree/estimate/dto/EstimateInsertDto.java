package com.mangopuree.estimate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.estimateitem.dto.EstimateItemDraftDto;
import com.mangopuree.estimateitem.dto.EstimateItemInsertDto;
import com.mangopuree.support.base.dto.BaseAuditDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class EstimateInsertDto extends BaseAuditDto {

    private String estimateId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate estimateDate;
    private String validDateCd;
    private String estimateStatusCd;
    private Long managerId;
    private String managerName;
    private String managerTelNo;
    private String managerFaxNo;
    private Long vendorId;
    private String vendorName;
    private String vendorTelNo;
    private String vendorFaxNo;
    private Long businessId;
    private String businessName;
    private String representativeName;
    private String registrationNumber;
    private String businessAddress;
    private String businessTelNo;
    private String businessFaxNo;
    private String businessType;
    private String industryType;
    private String remark;

    private List<EstimateItemInsertDto> itemList;
}
