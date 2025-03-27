package com.mangopuree.menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuDto {

    private Long menuId;
    private String menuName;
    private Long parentId;
    private int orderIndex;
    private String url;
    private List<SubMenuDto> subMenuList;
}
