package com.mangopuree.support.base;

import com.mangopuree.menu.service.MenuService;
import com.mangopuree.support.message.MessageUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseContoller implements BaseConstant{

    @Autowired
    private MessageUtil messageUtil;

    public Map<String, Object> setSuccessResult() {
        ModelMap model = new ModelMap();
        return setSuccessResult(model);
    }

    public Map<String, Object> setSuccessResult(Map<String, Object> model) {
        model.put(KEY_RESULT_CODE, CODE_SUCCESS);
        model.put(KEY_RESULT_MESSAGE, RESULT_SUCCESS);
        return model;
    }

    public Map<String, List<String>> setFieldErrors(BindingResult bindingResult) {
        Map<String, List<String>> fieldErrors = new HashMap<>();
        bindingResult.getFieldErrors().stream().forEach(error -> fieldErrors.computeIfAbsent(error.getField()
                , k -> new ArrayList<>()).add(messageUtil.get(error.getCode()+"."+error.getObjectName()+"."+error.getField())));
        return fieldErrors;
    }

    public Map<String, List<String>> setFieldError(BindingResult bindingResult) {
        Map<String, List<String>> fieldErrors = new HashMap<>();
        bindingResult.getFieldErrors().stream().forEach(error -> fieldErrors.computeIfAbsent(error.getField()
                , k -> new ArrayList<>()).add(messageUtil.get(error.getCode())));
        return fieldErrors;
    }

    public Map<String, Object> setFailResult(Map<String, Object> model, Exception e) {
        model.put(KEY_RESULT_CODE, CODE_FAIL);
        model.put(KEY_RESULT_MESSAGE, RESULT_FAIL);
        model.put(EXCEPTION_NAME, e.toString());
        model.put(EXCEPTION_MESSAGE, e.getMessage());
        return model;
    }

    public Map<String, Object> setFailResult(Map<String, Object> model, Map<String, List<String>> fieldErrors) {
        model.put(KEY_RESULT_CODE, CODE_FAIL);
        model.put(KEY_RESULT_MESSAGE, RESULT_FAIL);
        model.put("fieldErrors",fieldErrors);
        return model;
    }

}
