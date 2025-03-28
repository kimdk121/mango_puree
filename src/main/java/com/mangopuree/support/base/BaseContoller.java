package com.mangopuree.support.base;

import com.mangopuree.support.message.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseContoller implements BaseConstant{

    @Autowired
    private MessageUtil messageUtil;

    /**
     * API 호출 성공 메세지 저장
     * @return model
     */
    public Map<String, Object> setSuccessResult() {
        ModelMap model = new ModelMap();
        return setSuccessResult(model);
    }

    /**
     * API 호출 성공 메세지 저장
     * @param model
     * @return model
     */
    public Map<String, Object> setSuccessResult(Map<String, Object> model) {
        model.put(KEY_RESULT_CODE, CODE_SUCCESS);
        model.put(KEY_RESULT_MESSAGE, RESULT_SUCCESS);
        return model;
    }

    /**
     * API 에러메세지 저장 다중
     * @param bindingResult
     * @return fieldErrors
     */
    public Map<String, List<String>> setFieldErrors(BindingResult bindingResult) {
        Map<String, List<String>> fieldErrors = new HashMap<>();
        bindingResult.getFieldErrors().stream().forEach(error -> fieldErrors.computeIfAbsent(error.getField()
                , k -> new ArrayList<>()).add(messageUtil.get(error.getCode()+"."+error.getObjectName()+"."+error.getField())));
        return fieldErrors;
    }

    /**
     * API 에러메세지 저장 1개
     * @param bindingResult
     * @return fieldErrors
     */
    public Map<String, List<String>> setFieldError(BindingResult bindingResult) {
        Map<String, List<String>> fieldErrors = new HashMap<>();
        bindingResult.getFieldErrors().stream().forEach(error -> fieldErrors.computeIfAbsent(error.getField()
                , k -> new ArrayList<>()).add(messageUtil.get(error.getCode())));
        return fieldErrors;
    }

    /**
     * API Exception 통한 에러메세지 저장
     * @param model
     * @param e
     * @return model
     */
    public Map<String, Object> setFailResult(Map<String, Object> model, Exception e) {
        model.put(KEY_RESULT_CODE, CODE_FAIL);
        model.put(KEY_RESULT_MESSAGE, RESULT_FAIL);
        model.put(EXCEPTION_NAME, e.toString());
        model.put(EXCEPTION_MESSAGE, e.getMessage());
        return model;
    }

    /**
     * API 호출 실패 메세지 저장
     * @param model
     * @param fieldErrors
     * @return model
     */
    public Map<String, Object> setFailResult(Map<String, Object> model, Map<String, List<String>> fieldErrors) {
        model.put(KEY_RESULT_CODE, CODE_FAIL);
        model.put(KEY_RESULT_MESSAGE, RESULT_FAIL);
        model.put("fieldErrors",fieldErrors);
        return model;
    }

}
