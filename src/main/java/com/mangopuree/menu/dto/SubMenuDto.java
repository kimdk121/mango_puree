package com.mangopuree.menu.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "사용자 메뉴 조회 서브 DTO")
public class SubMenuDto {

    @Schema(description = "메뉴아이디", example = "3")
    private Long menuId;

    @Schema(description = "메뉴명", example = "견적서등록")
    private String menuName;

    @Schema(description = "상위메뉴아이디", example = "2")
    private Long parentId;

    @Schema(description = "순번", example = "1")
    private int orderIndex;

    @Schema(description = "URL", example = "/admin/estimate/insert")
    private String url;

    @Schema(description = "ICON", example = "fas fa-file-signature")
    private String icon;
}
