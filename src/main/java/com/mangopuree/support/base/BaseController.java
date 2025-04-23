package com.mangopuree.support.base;

import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.grid.dto.PaginationDto;
import com.mangopuree.support.grid.dto.RequestGridDto;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import com.mangopuree.support.message.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController implements BaseConstant{

    @Autowired
    private MessageUtil messageUtil;

    /**
     * Grid 필수 데이터 정렬
     * @param requestGridDto
     * @param contents
     * @param totalCount
     * @return
     * @param <T>
     */
    public <T> SetGridDataDto setGridData(RequestGridDto requestGridDto, List<T> contents, int totalCount) {
        return SetGridDataDto.<T>builder()
                .contents(contents)
                .pagination(PaginationDto.builder()
                        .page(requestGridDto.getPage())
                        .totalCount(totalCount)
                        .build()
                )
                .build();
    }

    /**
     * API 호출 성공
     * @return ResponseEntity<ApiResponseDto>
     */
    public ResponseEntity<ApiResponseDto> setSuccessResult() {
        return ResponseEntity.ok(ApiResponseDto.builder()
                .code(CODE_SUCCESS)
                .message(RESULT_SUCCESS)
                .result(true)
                .build()
        );
    }

    /**
     * API 호출 성공
     * @param data
     * @return ResponseEntity<ApiResponseDto>
     */
    public ResponseEntity<ApiResponseDto> setSuccessResult(Object data) {
        return ResponseEntity.ok(ApiResponseDto.builder()
                .code(CODE_SUCCESS)
                .message(RESULT_SUCCESS)
                .result(true)
                .data(data)
                .build()
        );
    }

    /**
     * API 호출 실패
     * @return ResponseEntity<ApiResponseDto>
     */
    public ResponseEntity<ApiResponseDto> setFailResult() {
        return ResponseEntity.badRequest().body(ApiResponseDto.builder()
                        .code(CODE_FAIL)
                        .message(RESULT_FAIL)
                        .result(false)
                        .build()
        );
    }

    /**
     * API 호출 실패
     * @param fieldErrors
     * @return ResponseEntity<ApiResponseDto>
     */
    public ResponseEntity<ApiResponseDto> setFailResult(Map<String, List<String>> fieldErrors) {
        return ResponseEntity.badRequest().body(ApiResponseDto.builder()
                .code(CODE_FAIL)
                .message(RESULT_FAIL)
                .result(false)
                .fieldErrors(fieldErrors)
                .build()
        );
    }

    /**
     * API 에러메세지 저장
     * @param bindingResult
     * @return fieldErrors
     */
    public Map<String, List<String>> setFieldErrors(BindingResult bindingResult) {
        Map<String, List<String>> fieldErrors = new HashMap<>();

        bindingResult.getFieldErrors().stream().forEach(error -> {
            String customErrorCode = error.getCode();
            String defaultErrorCode = error.getCode()+"."+error.getObjectName()+"."+error.getField();
            String message = null;
            try {
                message = messageUtil.get(defaultErrorCode);
            } catch (Exception e) {
                message = messageUtil.get(customErrorCode);
            }
            fieldErrors.computeIfAbsent(error.getField(), k -> new ArrayList<>()).add(message);
        });
        return fieldErrors;
    }
}
