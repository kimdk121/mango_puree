package com.mangopuree.movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.resttemplate.dto.ExternalRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MovieSearchDto extends ExternalRequestDto {

    private String cameraId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;
    private int duration;

}
