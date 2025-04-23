package com.mangopuree.support.base.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class ApiResponseDto<T> {

    private String code;
    private String message;
    private boolean result;
    private T data;
    private Map<String, List<String>> fieldErrors;
}
