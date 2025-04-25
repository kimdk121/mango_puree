package com.mangopuree.vendor.dto;

import com.mangopuree.support.grid.dto.ResponseGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "거래처 그리드 조회 DTO")
public class VendorGridDto extends ResponseGridDto {

    @Schema(description = "거래처아이디", example = "1")
    private Long vendorId;
    @Schema(description = "거래처명", example = "오박 식품")
    private String vendorName;
    @Schema(description = "대표자명", example = "권영식")
    private String representativeName;
    @Schema(description = "사업자등록번호", example = "864-30-89585")
    private String registrationNumber;
    @Schema(description = "주소", example = "부산광역시 송파구 선릉로")
    private String address;
    @Schema(description = "전화번호", example = "02-3181-5450")
    private String telNo;
    @Schema(description = "팩스번호", example = "053-842-7051")
    private String faxNo;
    @Schema(description = "업태", example = "소매")
    private String businessType;
    @Schema(description = "종목", example = "식품")
    private String industryType;
}
