package com.mangopuree.business.service;

import com.mangopuree.business.dto.BusinessGridDto;
import com.mangopuree.business.dto.BusinessSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessMapper businessMapper;

    /**
     * Grid용 사업자 조회
     * @param businessSearchDto
     * @return List<BusinessGridDto>
     */
    public List<BusinessGridDto> businessListByGrid(BusinessSearchDto businessSearchDto) {
        return businessMapper.businessListByGrid(businessSearchDto);
    }
}
