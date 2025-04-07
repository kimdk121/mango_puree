package com.mangopuree.user.controller;

import com.mangopuree.business.dto.BusinessGridDto;
import com.mangopuree.support.base.BaseContoller;
import com.mangopuree.support.base.dto.RequestGridDto;
import com.mangopuree.user.dto.UserGridDto;
import com.mangopuree.user.dto.UserPasswordUpdateDto;
import com.mangopuree.user.dto.UserSearchDto;
import com.mangopuree.user.dto.UserUpdateDto;
import com.mangopuree.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController extends BaseContoller {

    private final UserService userService;

    /**
     * API 사용자전체 Grid 호출
     */
    @GetMapping("/list")
    public Map<String, Object> list(@ModelAttribute UserSearchDto userSearchDto) {
        ModelMap model = new ModelMap();
        userSearchDto.calculatePaging();
        List<UserGridDto> userGridDtos = userService.userListByGrid(userSearchDto);
        if (userGridDtos == null) {
            return setFailResult(model);
        }
        int totalCount = userGridDtos.get(0).getTotalCount();

        Map<String, Object> data = setGridData(userSearchDto, userGridDtos, totalCount);
        model.addAttribute("data", data);

        return setSuccessResult(model);
    }

    /**
     * API 사용자 호출
     */
    @GetMapping("/loadUserInfo")
    public Map<String, Object> loadUserInfo(Authentication authentication) {
        ModelMap model = new ModelMap();
        model.addAttribute("user",userService.findByUserId(authentication.getName()));
        return setSuccessResult(model);
    }

    /**
     * API 사용자 수정
     */
    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody @Validated UserUpdateDto userUpdateDto, BindingResult bindingResult) {
        ModelMap model = new ModelMap();
        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(model, fieldErrors);
        }

        userService.updateByUserId(userUpdateDto);
        return setSuccessResult();
    }

    /**
     * API 비밀번호 수정
     */
    @PostMapping("/updatePassword")
    public Map<String, Object> updatePassword(@RequestBody @Validated UserPasswordUpdateDto userPasswordUpdateDto, BindingResult bindingResult) {
        ModelMap model = new ModelMap();
        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(model, fieldErrors);
        }
        if (!userPasswordUpdateDto.isPasswordMatching()) {
            bindingResult.rejectValue("password", "mismatch.password");
            Map<String, List<String>> fieldErrors = setFieldError(bindingResult);
            return setFailResult(model, fieldErrors);
        }

        userService.updatePasswordByUserId(userPasswordUpdateDto);
        return setSuccessResult();
    }
}
