package com.mangopuree.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SubMenuDto {

    private Long menuId;
    private String menuName;
    private Long parentId;
    private int orderIndex;
    private String url;
}
