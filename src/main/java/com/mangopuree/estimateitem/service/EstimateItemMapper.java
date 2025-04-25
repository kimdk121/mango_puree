package com.mangopuree.estimateitem.service;

import com.mangopuree.estimateitem.dto.EstimateItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EstimateItemMapper {

    /**
     * 견적서아이디로 조회
     * @param estimateId
     * @return List<EstimateItemDto>
     */
    List<EstimateItemDto> findByEstimateId(String estimateId);

    /**
     * 견적서아이디로 삭제
     * @param estimateId
     * @return int
     */
    int deleteByEstimateId(String estimateId);

    /**
     * 한꺼번에 저장
     * @param estimateItemList
     * @return int
     */
    int bulkInsert(Map<String, Object> estimateItemList);
}
