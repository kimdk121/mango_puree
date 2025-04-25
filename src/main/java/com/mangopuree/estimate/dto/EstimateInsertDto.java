package com.mangopuree.estimate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.estimateitem.dto.EstimateItemInsertDto;
import com.mangopuree.support.base.dto.BaseAuditDto;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "견적서 등록 DTO")
public class EstimateInsertDto extends BaseAuditDto {

    @Schema(description = "견적서아이디", example = "EST25040700010", requiredMode = Schema.RequiredMode.REQUIRED)
    private String estimateId;

    @Schema(description = "견적일자", example = "2025-04-08")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate estimateDate;

    @Schema(description = "유효기간코드", example = "VAD002")
    @NotBlank
    private String validDateCd;

    @Schema(description = "상태코드", example = "ESS002")
    private String estimateStatusCd;

    @Schema(description = "담당자아이디", example = "1")
    private Long managerId;

    @Schema(description = "담당자아이디", example = "관리자")
    @NotBlank
    private String managerName;

    @Schema(description = "담당자전화번호", example = "010-1010-1010")
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String managerTelNo;

    @Schema(description = "담당자팩스번호", example = "02-1010-1010")
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String managerFaxNo;

    @Schema(description = "거래처아이디", example = "6")
    private Long vendorId;

    @Schema(description = "거래처명", example = "이이 식품")
    @NotBlank
    private String vendorName;

    @Schema(description = "거래처전화번호", example = "051-051-4779")
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String vendorTelNo;

    @Schema(description = "거래처팩스번호", example = "053-973-6140")
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String vendorFaxNo;

    @Schema(description = "사업자아이디", example = "2")
    private Long businessId;

    @Schema(description = "사업자명", example = "망고퓨레 지사")
    @NotBlank
    private String businessName;

    @Schema(description = "대표자명", example = "김동균")
    @NotBlank
    private String representativeName;

    @Schema(description = "사업자등록번호", example = "010-31-72784")
    @NotBlank
    private String registrationNumber;

    @Schema(description = "사업자주소", example = "부산광역시 해운대구 지사로 2길")
    @NotBlank
    private String businessAddress;

    @Schema(description = "사업자전화번호", example = "031-101-1015")
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String businessTelNo;

    @Schema(description = "사업자팩스번호", example = "031-102-1022")
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String businessFaxNo;

    @Schema(description = "업태", example = "유통")
    @NotBlank
    private String businessType;

    @Schema(description = "종목", example = "식품")
    @NotBlank
    private String industryType;

    @Schema(description = "비고", example = "qq")
    private String remark;

    @Schema(description = "견적서 품목", nullable = true)
    @Valid
    @NotEmpty
    private List<EstimateItemInsertDto> itemList;
}
