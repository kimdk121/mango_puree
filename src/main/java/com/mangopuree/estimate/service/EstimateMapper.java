package com.mangopuree.estimate.service;

import com.mangopuree.estimate.dto.EstimateDraftDto;
import com.mangopuree.estimate.dto.EstimateInsertDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EstimateMapper {

    String findNextEstimateId();

    int insert(EstimateInsertDto estimateInsertDto);
}
