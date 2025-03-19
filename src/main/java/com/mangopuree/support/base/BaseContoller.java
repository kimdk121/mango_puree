package com.mangopuree.support.base;

import java.util.Map;

public class BaseContoller implements BaseConstant{

    public Map<String, Object> setSuccessResult(Map<String, Object> model) {
        model.put(KEY_RESULT_CODE, CODE_SUCCESS);
        model.put(KEY_RESULT_MESSAGE, RESULT_SUCCESS);
        return model;
    }

    public Map<String, Object> setFailResult(Map<String, Object> model, Exception e) {
        model.put(KEY_RESULT_CODE, CODE_FAIL);
        model.put(KEY_RESULT_MESSAGE, RESULT_FAIL);
        model.put(EXCEPTION_NAME, e.toString());
        model.put(EXCEPTION_MESSAGE, e.getMessage());
        return model;
    }
}
