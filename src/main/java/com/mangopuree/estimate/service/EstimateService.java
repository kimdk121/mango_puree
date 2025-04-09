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
    public int insertTemp(EstimateDraftDto estimateDraftDto) {
        String estimateId = estimateMapper.findNextEstimateId();
        Long regId = LoginUserHolder.getAsLong();

        EstimateInsertDto estimateInsertDto = estimateDraftDto.toEstimateInsertDto(estimateId, regId);
        return insertInternal(estimateInsertDto);
    }

    @Transactional
    public int insertDone(EstimateSubmitDto estimateSubmitDto) {
        String estimateId = estimateMapper.findNextEstimateId();
        Long regId = LoginUserHolder.getAsLong();

        EstimateInsertDto estimateInsertDto = estimateSubmitDto.toEstimateInsertDto(estimateId, regId);
        return insertInternal(estimateInsertDto);
    }

    @Transactional
    public int updateTemp(EstimateDraftDto estimateDraftDto) {
        Long updId = LoginUserHolder.getAsLong();

        EstimateUpdateDto estimateUpdateDto = estimateDraftDto.toEstimateUpdateDto(updId);
        return updateInternal(estimateUpdateDto);
    }

    @Transactional
    public int updateDone(EstimateSubmitDto estimateSubmitDto) {
        Long updId = LoginUserHolder.getAsLong();

        EstimateUpdateDto estimateUpdateDto = estimateSubmitDto.toEstimateUpdateDto(updId);
        return updateInternal(estimateUpdateDto);
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

    private int updateInternal(EstimateUpdateDto estimateUpdateDto) {
        int result = estimateMapper.update(estimateUpdateDto);

        if (estimateUpdateDto.getItemList() != null && !estimateUpdateDto.getItemList().isEmpty()) {
            estimateItemMapper.deleteByEstimateId(estimateUpdateDto.getEstimateId());

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("estimateId", estimateUpdateDto.getEstimateId());
            paramMap.put("itemList", estimateUpdateDto.getItemList());
            paramMap.put("regId", estimateUpdateDto.getRegId());
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
