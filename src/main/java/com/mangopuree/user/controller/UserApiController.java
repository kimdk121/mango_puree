package com.mangopuree.user.controller;

import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import com.mangopuree.user.dto.*;
import com.mangopuree.user.service.UserService;
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

    /**
     * API 사용자전체 Grid 호출
     */
    @GetMapping("/list")
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

    /**
     * API 사용자 호출
     */
    @GetMapping("/loadUserInfo")
    public ResponseEntity<ApiResponseDto> loadUserInfo(Authentication authentication) {
        UserDto user = userService.findByUserId(authentication.getName());
        return setSuccessResult(user);
    }

    /**
     * API 사용자 수정
     */
    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto> update(@RequestBody @Validated UserUpdateDto userUpdateDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(fieldErrors);
        }
        userService.updateByUserId(userUpdateDto);
        return setSuccessResult();
    }

    /**
     * API 비밀번호 수정
     */
    @PostMapping("/updatePassword")
    public ResponseEntity<ApiResponseDto> updatePassword(@RequestBody @Validated UserPasswordUpdateDto userPasswordUpdateDto, BindingResult bindingResult) {

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
