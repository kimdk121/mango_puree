package com.mangopuree.menu.controller;

import com.mangopuree.menu.dto.MenuDto;
import com.mangopuree.menu.service.MenuService;
import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuApiController extends BaseController {

    private final MenuService menuService;

    /**
     * API 메뉴 호출
     */
    @GetMapping("/loadUserMenu")
    public ResponseEntity<ApiResponseDto> loadUserMenu(Authentication authentication) {
        List<MenuDto> menuList = menuService.findMenuListByUserId(authentication.getName());
        return setSuccessResult(menuList);
    }
}
