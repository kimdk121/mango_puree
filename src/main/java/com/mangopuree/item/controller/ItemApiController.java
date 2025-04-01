package com.mangopuree.item.controller;

import com.mangopuree.business.dto.BusinessSearchDto;
import com.mangopuree.item.service.ItemService;
import com.mangopuree.user.dto.UserGridDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemApiController {

    private final ItemService itemService;
}
