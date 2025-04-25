package com.mangopuree.item.service;

import com.mangopuree.item.dto.ItemGridDto;
import com.mangopuree.item.dto.ItemSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper itemMapper;

    /**
     * Grid용 품목 조회
     * @param itemSearchDto
     * @return List<BusinessGridDto>
     */
    public List<ItemGridDto> businessListByGrid(ItemSearchDto itemSearchDto) {
        return itemMapper.itemListByGrid(itemSearchDto);
    }
}
