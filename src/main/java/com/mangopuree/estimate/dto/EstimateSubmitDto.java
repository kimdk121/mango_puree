package com.mangopuree.estimate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.estimateitem.dto.EstimateItemDraftDto;
import com.mangopuree.estimateitem.dto.EstimateItemInsertDto;
import com.mangopuree.estimateitem.dto.EstimateItemSubmitDto;
import com.mangopuree.estimateitem.dto.EstimateItemUpdateDto;
import com.mangopuree.support.base.dto.BaseAuditDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class EstimateSubmitDto extends BaseAuditDto {

    private String estimateId;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate estimateDate;

    @NotBlank
    private String validDateCd;

    private String estimateStatusCd;

    private Long managerId;
    @NotBlank
    private String managerName;
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String managerTelNo;
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String managerFaxNo;

    private Long vendorId;
    @NotBlank
    private String vendorName;
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String vendorTelNo;
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String vendorFaxNo;

    private Long businessId;
    @NotBlank
    private String businessName;
    @NotBlank
    private String representativeName;
    @NotBlank
    private String registrationNumber;
    @NotBlank
    private String businessAddress;
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String businessTelNo;
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String businessFaxNo;
    @NotBlank
    private String businessType;
    @NotBlank
    private String industryType;

    private String remark;

    @Valid
    @NotEmpty
    private List<EstimateItemSubmitDto> itemList;

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

    public EstimateUpdateDto toEstimateUpdateDto(Long updId) {

        List<EstimateItemUpdateDto> updateItems = null;
        if (this.itemList != null) {
            updateItems = this.itemList.stream().map(item -> item.toUpdateDto(updId)).toList();
        }

        return EstimateUpdateDto.builder()
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
                .updId(updId)
                .itemList(updateItems)
                .build();
    }
}
