package com.mangopuree.vendor.service;

import com.mangopuree.vendor.dto.VendorGridDto;
import com.mangopuree.vendor.dto.VendorSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorMapper vendorMapper;

    /**
     * Grid용 거래처 조회
     * @param vendorSearchDto
     * @return List<VendorGridDto>
     */
    public List<VendorGridDto> vendorListByGrid(VendorSearchDto vendorSearchDto) {
        return vendorMapper.vendorListByGrid(vendorSearchDto);
    }
}
