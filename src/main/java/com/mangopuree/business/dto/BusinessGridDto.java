package com.mangopuree.business.dto;

import com.mangopuree.support.grid.dto.ResponseGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "사업자 그리드 조회 DTO")
public class BusinessGridDto extends ResponseGridDto {

    @Schema(description = "사업자아이디", example = "1")
    private Long businessId;

    @Schema(description = "상호명", example = "망고퓨레 본사")
    private String businessName;

    @Schema(description = "대표자명", example = "김동균")
    private String representativeName;

    @Schema(description = "사업자등록번호", example = "010-31-72784")
    private String registrationNumber;

    @Schema(description = "주소", example = "서울특별시 강남구 본사로 1길")
    private String address;

    @Schema(description = "전화번호", example = "031-101-1010")
    private String telNo;

    @Schema(description = "팩스번호", example = "031-101-1011")
    private String faxNo;

    @Schema(description = "업태", example = "유통")
    private String businessType;

    @Schema(description = "종목", example = "식품")
    private String industryType;
}
