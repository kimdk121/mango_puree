package com.mangopuree.user.controller;

import com.mangopuree.support.base.BaseContoller;
import com.mangopuree.user.dto.UserUpdateDto;
import com.mangopuree.user.dto.UserPasswordUpdateDto;
import com.mangopuree.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class UserController extends BaseContoller {

    private final UserService userService;

    @GetMapping
    public String listForm(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/user/list";
    }

    @GetMapping("/loadUserInfo")
    @ResponseBody
    public Map<String, Object> loadUserInfo(Authentication authentication) {
        ModelMap model = new ModelMap();
        model.addAttribute("user",userService.findByUserId(authentication.getName()));
        return setSuccessResult(model);
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> update(@RequestBody @Validated UserUpdateDto userUpdateDto, BindingResult bindingResult) {
        ModelMap model = new ModelMap();
        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(model, fieldErrors);
        }

        userService.updateByUserId(userUpdateDto);
        return setSuccessResult();
    }

    @PostMapping("/updatePassword")
    @ResponseBody
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
