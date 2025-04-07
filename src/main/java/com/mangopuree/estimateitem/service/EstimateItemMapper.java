package com.mangopuree.estimateitem.service;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface EstimateItemMapper {

    int bulkInsert(Map<String, Object> estimateItemList);
}
