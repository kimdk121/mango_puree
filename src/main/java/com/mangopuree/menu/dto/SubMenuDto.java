package com.mangopuree.menu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubMenuDto {

    private Long menuId;
    private String menuName;
    private int orderIndex;
    private String url;
}
