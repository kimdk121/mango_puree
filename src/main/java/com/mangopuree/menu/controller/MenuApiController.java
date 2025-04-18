package com.mangopuree.menu.controller;

import com.mangopuree.menu.dto.MenuDto;
import com.mangopuree.menu.service.MenuService;
import com.mangopuree.support.base.BaseContoller;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuApiController extends BaseContoller {

    private final MenuService menuService;

    /**
     * API 메뉴 호출
     */
    @GetMapping("/loadUserMenu")
    public Map<String, Object> loadUserMenu(Authentication authentication) {
        ModelMap model = new ModelMap();
        List<MenuDto> menuList = menuService.findMenuListByUserId(authentication.getName());

        model.addAttribute("menuList",menuList);

        return setSuccessResult(model);
    }
}
