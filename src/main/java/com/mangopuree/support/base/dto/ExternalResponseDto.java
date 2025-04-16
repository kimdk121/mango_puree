package com.mangopuree.support.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ExternalResponseDto<T> {

    private String responseId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime responseDt;
    private String resultCode;
    private String resultMessage;
    private List<T> data;
}