package com.mangopuree.menu.service;

import com.mangopuree.menu.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    /**
     * 유저아이디로 메뉴 리스트 호출
     * @param userId
     * @return List<MenuDto>
     */
    List<MenuDto> findMenuListByUserId(String userId);

    /**
     * URL로 메뉴 호출
     * @param url
     * @return MenuDto
     */
    MenuDto getMenuByUrl(String url);

    /**
     * 메뉴아이디로 메뉴 호출
     * @param menuId
     * @return MenuDto
     */
    MenuDto getMenuByMenuId(Long menuId);
}
