package com.mangopuree.estimateitem.service;

import com.mangopuree.estimateitem.dto.EstimateItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EstimateItemMapper {

    List<EstimateItemDto> findByEstimateId(String estimateId);

    int deleteByEstimateId(String estimateId);

    int bulkInsert(Map<String, Object> estimateItemList);
}
