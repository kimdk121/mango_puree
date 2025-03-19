package com.mangopuree.menu.service;

import com.mangopuree.menu.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuDto> findMenuListByUserId(String userId);
}
