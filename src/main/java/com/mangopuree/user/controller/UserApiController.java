package com.mangopuree.user.controller;

import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import com.mangopuree.user.dto.*;
import com.mangopuree.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController extends BaseController {

    private final UserService userService;

    @GetMapping("/list")
    @Operation(summary = "사용자 Grid 정보 조회", description = "조건에 따른 사용자 Grid 정보를 조회합니다.")
    public ResponseEntity<ApiResponseDto> list(@ModelAttribute UserSearchDto userSearchDto) {

        userSearchDto.calculatePaging();
        List<UserGridDto> userGridDtos = userService.userListByGrid(userSearchDto);
        int totalCount = 0;
        if (userGridDtos.size() > 0) {
            totalCount = userGridDtos.get(0).getTotalCount();
        }
        SetGridDataDto data = setGridData(userSearchDto, userGridDtos, totalCount);
        return setSuccessResult(data);
    }

    @GetMapping("/loadUserInfo")
    @Operation(summary = "사용자 정보 조회", description = "사용자의 정보를 조회합니다.")
    public ResponseEntity<ApiResponseDto> loadUserInfo(Authentication authentication) {
        UserDto user = userService.findByUserId(authentication.getName());
        return setSuccessResult(user);
    }

    @PostMapping("/update")
    @Operation(summary = "사용자 수정", description = "사용자의 정보를 수정합니다.")
    public ResponseEntity<ApiResponseDto> update(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "사용자 수정 DTO", required = true) @RequestBody @Validated UserUpdateDto userUpdateDto,
                                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(fieldErrors);
        }
        userService.updateByUserId(userUpdateDto);
        return setSuccessResult();
    }

    @PostMapping("/updatePassword")
    @Operation(summary = "사용자 비밀번호 수정", description = "사용자의 비밀번호를 수정합니다.")
    public ResponseEntity<ApiResponseDto> updatePassword(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "사용자 비밀번호 수정 DTO", required = true) @RequestBody @Validated UserPasswordUpdateDto userPasswordUpdateDto,
                                                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(fieldErrors);
        }
        if (!userPasswordUpdateDto.isPasswordMatching()) {
            bindingResult.rejectValue("password", "mismatch.password");
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(fieldErrors);
        }
        userService.updatePasswordByUserId(userPasswordUpdateDto);
        return setSuccessResult();
    }
}
