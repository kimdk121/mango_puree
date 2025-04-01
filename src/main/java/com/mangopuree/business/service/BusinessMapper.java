package com.mangopuree.business.service;

import com.mangopuree.business.dto.BusinessGridDto;
import com.mangopuree.business.dto.BusinessSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusinessMapper {

    List<BusinessGridDto> businessListByGrid(BusinessSearchDto businessSearchDto);
}
