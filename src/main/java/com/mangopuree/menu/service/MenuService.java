package com.mangopuree.menu.service;

import com.mangopuree.menu.dto.MenuDto;
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
}
