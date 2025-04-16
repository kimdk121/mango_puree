package com.mangopuree.item.controller;

import com.mangopuree.item.dto.ItemGridDto;
import com.mangopuree.item.dto.ItemSearchDto;
import com.mangopuree.item.service.ItemService;
import com.mangopuree.support.base.BaseContoller;
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
public class ItemApiController extends BaseContoller {

    private final ItemService itemService;

    /**
     * API 사업자 Grid 호출
     */
    @GetMapping("/list")
    public Map<String, Object> list(@ModelAttribute ItemSearchDto itemSearchDto) {
        ModelMap model = new ModelMap();
        itemSearchDto.calculatePaging();
        List<ItemGridDto> itemGridDtos = itemService.businessListByGrid(itemSearchDto);
        int totalCount = 0;
        if (itemGridDtos.size() > 0) {
            totalCount = itemGridDtos.get(0).getTotalCount();
        }
        Map<String, Object> data = setGridData(itemSearchDto, itemGridDtos, totalCount);
        model.addAttribute("data", data);

        return setSuccessResult(model);
    }
}
