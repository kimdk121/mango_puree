package com.mangopuree.vendor.controller;

import com.mangopuree.business.dto.BusinessSearchDto;
import com.mangopuree.support.base.BaseContoller;
import com.mangopuree.user.dto.UserGridDto;
import com.mangopuree.vendor.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vendor")
public class VendorApiController extends BaseContoller {

    private final VendorService vendorService;

}
