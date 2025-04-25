package com.mangopuree.vendor.service;

import com.mangopuree.vendor.dto.VendorGridDto;
import com.mangopuree.vendor.dto.VendorSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VendorMapper {

    /**
     * Grid용 거래처 조회
     * @param vendorSearchDto
     * @return List<VendorGridDto>
     */
    List<VendorGridDto> vendorListByGrid(VendorSearchDto vendorSearchDto);
}
