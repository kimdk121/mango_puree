package com.mangopuree.estimate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.estimateitem.dto.EstimateItemInsertDto;
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

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class EstimateInsertDto extends BaseAuditDto {

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
    private List<EstimateItemInsertDto> itemList;
}
