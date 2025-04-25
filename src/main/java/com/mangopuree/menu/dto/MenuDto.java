package com.mangopuree.menu.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(description = "사용자 메뉴 조회 DTO")
public class MenuDto {

    @Schema(description = "메뉴아이디", example = "2")
    private Long menuId;

    @Schema(description = "메뉴명", example = "견적서")
    private String menuName;

    @Schema(description = "상위메뉴아이디")
    private Long parentId;

    @Schema(description = "순번", example = "2")
    private int orderIndex;

    @Schema(description = "URL")
    private String url;

    @Schema(description = "하위 메뉴", nullable = true)
    private List<SubMenuDto> subMenuList;
}
