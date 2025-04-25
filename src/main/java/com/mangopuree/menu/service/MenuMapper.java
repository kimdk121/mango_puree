package com.mangopuree.menu.service;

import com.mangopuree.menu.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    /**
     * 사용자 메뉴 조회
     * @param userId
     * @return List<MenuDto>
     */
    List<MenuDto> findMenuListByUserId(String userId);

    /**
     * URL로 조회
     * @param url
     * @return MenuDto
     */
    MenuDto getMenuByUrl(String url);

    /**
     * 메뉴아이디로 조회
     * @param menuId
     * @return MenuDto
     */
    MenuDto getMenuByMenuId(Long menuId);
}
