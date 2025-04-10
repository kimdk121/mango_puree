package com.mangopuree.estimate.service;

import com.mangopuree.estimate.dto.*;
import com.mangopuree.user.dto.UserGridDto;
import com.mangopuree.user.dto.UserSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EstimateMapper {

    String findNextEstimateId();

    int insert(EstimateInsertDto estimateInsertDto);

    int updateByEstimateId(EstimateInsertDto estimateUpdateDto);

    int deleteByEstimateId(String estimateId);

    EstimateDto findByEstimateId(String EstimateId);

    /**
     * 그리드용 견적서 전체조회
     * @param estimateSearchDto
     * @return List<UserGridDto>
     */
    List<EstimateGridDto> estimateListByGrid(EstimateSearchDto estimateSearchDto);

    int confirmEstimateStatus(String estimateId, Long updId);
}
