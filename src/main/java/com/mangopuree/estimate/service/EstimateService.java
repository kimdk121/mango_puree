package com.mangopuree.estimate.service;

import com.mangopuree.estimate.dto.EstimateDraftDto;
import com.mangopuree.estimate.dto.EstimateInsertDto;
import com.mangopuree.estimate.dto.EstimateSubmitDto;
import com.mangopuree.estimateitem.service.EstimateItemMapper;
import com.mangopuree.support.security.LoginUserHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EstimateService {

    private final EstimateMapper estimateMapper;
    private final EstimateItemMapper estimateItemMapper;

    @Transactional
    public int insertTemp(EstimateDraftDto estimateDraftDto) {
        String estimateId = estimateMapper.findNextEstimateId();
        Long regId = LoginUserHolder.getAsLong();

        EstimateInsertDto estimateInsertDto = estimateDraftDto.toEstimateInsertDto(estimateId, regId);
        return insertInternal(estimateInsertDto);
    }

    @Transactional
    public int insertDone(EstimateSubmitDto EstimateSubmitDto) {
        String estimateId = estimateMapper.findNextEstimateId();
        Long regId = LoginUserHolder.getAsLong();

        EstimateInsertDto estimateInsertDto = EstimateSubmitDto.toEstimateInsertDto(estimateId, regId);
        return insertInternal(estimateInsertDto);
    }

    private int insertInternal(EstimateInsertDto estimateInsertDto) {
        int result = estimateMapper.insert(estimateInsertDto);

        if (estimateInsertDto.getItemList() != null && !estimateInsertDto.getItemList().isEmpty()) {
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("estimateId", estimateInsertDto.getEstimateId());
            paramMap.put("itemList", estimateInsertDto.getItemList());
            paramMap.put("regId", estimateInsertDto.getRegId());
            estimateItemMapper.bulkInsert(paramMap);
        }
        return result;
    }

}
