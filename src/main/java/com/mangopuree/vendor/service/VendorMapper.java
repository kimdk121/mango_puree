package com.mangopuree.vendor.service;

import com.mangopuree.business.dto.BusinessGridDto;
import com.mangopuree.business.dto.BusinessSearchDto;
import com.mangopuree.vendor.dto.VendorGridDto;
import com.mangopuree.vendor.dto.VendorSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VendorMapper {

    /**
     * Grid용 거래처 전체조회
     * @param vendorSearchDto
     * @return List<VendorGridDto>
     */
    List<VendorGridDto> vendorListByGrid(VendorSearchDto vendorSearchDto);
}
