package com.mangopuree.menu.controller;

import com.mangopuree.menu.dto.MenuDto;
import com.mangopuree.menu.service.MenuService;
import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping("/loadUserMenu")
    @Operation(summary = "사용자의 메뉴 정보 조회", description = "사용자의 메뉴 정보를 조회합니다.")
    public ResponseEntity<ApiResponseDto> loadUserMenu(Authentication authentication) {
        List<MenuDto> menuList = menuService.findMenuListByUserId(authentication.getName());
        return setSuccessResult(menuList);
    }
}
