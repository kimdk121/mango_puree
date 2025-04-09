package com.mangopuree.estimate.service;

import com.mangopuree.estimate.dto.*;
import com.mangopuree.estimateitem.dto.EstimateItemDto;
import com.mangopuree.estimateitem.service.EstimateItemMapper;
import com.mangopuree.support.security.LoginUserHolder;
import com.mangopuree.user.dto.UserGridDto;
import com.mangopuree.user.dto.UserSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EstimateService {

    private final EstimateMapper estimateMapper;
    private final EstimateItemMapper estimateItemMapper;

    @Transactional
    public int insert(EstimateInsertDto estimateInsertDto) {
        String estimateId = estimateMapper.findNextEstimateId();
        Long regId = LoginUserHolder.getAsLong();
        estimateInsertDto.setEstimateId(estimateId);
        estimateInsertDto.setRegId(regId);

        int result = estimateMapper.insert(estimateInsertDto);

        if (estimateInsertDto.getItemList() != null && !estimateInsertDto.getItemList().isEmpty()) {
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("estimateId", estimateId);
            paramMap.put("itemList", estimateInsertDto.getItemList());
            paramMap.put("regId", regId);
            estimateItemMapper.bulkInsert(paramMap);
        }
        return result;
    }

    @Transactional
    public int update(EstimateInsertDto estimateInsertDto) {
        Long updId = LoginUserHolder.getAsLong();
        String estimateId = estimateInsertDto.getEstimateId();
        estimateInsertDto.setUpdId(updId);

        int result = estimateMapper.update(estimateInsertDto);

        if (estimateInsertDto.getItemList() != null && !estimateInsertDto.getItemList().isEmpty()) {
            estimateItemMapper.deleteByEstimateId(estimateId);

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("estimateId", estimateId);
            paramMap.put("itemList", estimateInsertDto.getItemList());
            paramMap.put("regId", updId);
            estimateItemMapper.bulkInsert(paramMap);
        }
        return result;
    }

    /**
     * 그리드용 견적서 전체조회
     * @param estimateSearchDto
     * @return List<EstimateGridDto>
     */
    public List<EstimateGridDto> estimateListByGrid(EstimateSearchDto estimateSearchDto) {
        return estimateMapper.estimateListByGrid(estimateSearchDto);
    }

    public EstimateDto findEstimateDetail(String estimateId) {
        EstimateDto estimateDto = estimateMapper.findByEstimateId(estimateId);
        estimateDto.setItemList(estimateItemMapper.findByEstimateId(estimateId));
        return estimateDto;
    }
}
