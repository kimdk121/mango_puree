package com.mangopuree.estimate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.estimateitem.dto.EstimateItemDraftDto;
import com.mangopuree.estimateitem.dto.EstimateItemInsertDto;
import com.mangopuree.support.base.dto.BaseAuditDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class EstimateDraftDto extends BaseAuditDto {

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

    private List<EstimateItemDraftDto> itemList;

    public EstimateInsertDto toEstimateInsertDto(String estimateId, Long regId) {

        List<EstimateItemInsertDto> insertItems = null;
        if (this.itemList != null) {
            insertItems = this.itemList.stream().map(item -> item.toInsertDto(estimateId, regId)).toList();
        }

        return EstimateInsertDto.builder()
                .estimateId(estimateId)
                .estimateDate(this.estimateDate)
                .validDateCd(this.validDateCd)
                .estimateStatusCd(this.estimateStatusCd)
                .managerId(this.managerId)
                .managerName(this.managerName)
                .managerTelNo(this.managerTelNo)
                .managerFaxNo(this.managerFaxNo)
                .vendorId(this.vendorId)
                .vendorName(this.vendorName)
                .vendorTelNo(this.vendorTelNo)
                .vendorFaxNo(this.vendorFaxNo)
                .businessId(this.businessId)
                .businessName(this.businessName)
                .representativeName(this.representativeName)
                .registrationNumber(this.registrationNumber)
                .businessAddress(this.businessAddress)
                .businessTelNo(this.businessTelNo)
                .businessFaxNo(this.businessFaxNo)
                .businessType(this.businessType)
                .industryType(this.industryType)
                .remark(this.remark)
                .regId(regId)
                .itemList(insertItems)
                .build();
    }
}
