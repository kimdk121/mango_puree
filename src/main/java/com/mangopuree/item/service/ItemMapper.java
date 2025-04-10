package com.mangopuree.item.service;

import com.mangopuree.item.dto.ItemGridDto;
import com.mangopuree.item.dto.ItemSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    /**
     * Grid용 품목 전체조회
     * @param itemSearchDto
     * @return List<ItemGridDto>
     */
    List<ItemGridDto> itemListByGrid(ItemSearchDto itemSearchDto);
}
