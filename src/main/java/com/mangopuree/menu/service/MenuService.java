package com.mangopuree.menu.service;

import com.mangopuree.menu.dto.MenuDto;
import com.mangopuree.menu.dto.SubMenuDto;
import com.mangopuree.support.exception.CodeException;
import com.mangopuree.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuMapper menuMapper;

    public List<MenuDto> findMenuListByUserId(String userId) {
        return menuMapper.findMenuListByUserId(userId);
    }

    public MenuDto getCurrentMenuByUrl(String url) {

        MenuDto currentMenu = menuMapper.getMenuByUrl(url);

        if (currentMenu == null) {
            throw new CodeException(ErrorCode.MENU_NOT_FOUND);
        }
        // 1뎁스 메뉴
        if (currentMenu.getParentId() == null) {
            return currentMenu;
        }

        // 2뎁스 메뉴
        MenuDto parentMenu = menuMapper.getMenuByMenuId(currentMenu.getParentId());

        if (parentMenu == null) {
            throw new CodeException(ErrorCode.PARENT_MENU_NOT_FOUND);
        }
        SubMenuDto subMenuDto = new SubMenuDto(currentMenu.getMenuId(), currentMenu.getMenuName(), currentMenu.getParentId(), currentMenu.getOrderIndex(), currentMenu.getUrl());

        parentMenu.setSubMenuList(List.of(subMenuDto));
        return parentMenu;
    }
}
