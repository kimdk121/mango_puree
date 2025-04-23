package com.mangopuree.menu.controller;

import com.mangopuree.menu.service.MenuService;
import com.mangopuree.support.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/menu")
public class MenuController extends BaseController {

    private final MenuService menuService;

}
