package com.mangopuree.item.controller;

import com.mangopuree.item.dto.ItemGridDto;
import com.mangopuree.item.dto.ItemSearchDto;
import com.mangopuree.item.service.ItemService;
import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemApiController extends BaseController {

    private final ItemService itemService;

    /**
     * API 사업자 Grid 호출
     */
    @GetMapping("/list")
    public ResponseEntity<ApiResponseDto> list(@ModelAttribute ItemSearchDto itemSearchDto) {

        itemSearchDto.calculatePaging();
        List<ItemGridDto> itemGridDtos = itemService.businessListByGrid(itemSearchDto);
        int totalCount = 0;
        if (itemGridDtos.size() > 0) {
            totalCount = itemGridDtos.get(0).getTotalCount();
        }
        SetGridDataDto data = setGridData(itemSearchDto, itemGridDtos, totalCount);
        return setSuccessResult(data);
    }
}
