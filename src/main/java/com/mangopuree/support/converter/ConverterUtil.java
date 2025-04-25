package com.mangopuree.support.converter;

import com.mangopuree.movie.dto.MovieSearchDto;
import com.mangopuree.nvrschedule.dto.NvrScheduleDto;

import java.time.LocalDateTime;

public class ConverterUtil {

    /**
     * NvrScheduleDto -> MovieSearchDto
     * @param nvrScheduleDto
     * @return MovieSearchDto
     */
    public static MovieSearchDto convertToMovieSearchDto(NvrScheduleDto nvrScheduleDto) {
        LocalDateTime startDate = nvrScheduleDto.getLastDownloadDt() == null
                ? LocalDateTime.now()
                : nvrScheduleDto.getLastDownloadDt().plusMinutes(nvrScheduleDto.getDuration());
        LocalDateTime endDate = startDate.plusMinutes(nvrScheduleDto.getDuration());

        return MovieSearchDto.builder()
                .cameraId(nvrScheduleDto.getCameraId())
                .startDate(startDate)
                .endDate(endDate)
                .duration(nvrScheduleDto.getDuration())
                .build();
    }
}
