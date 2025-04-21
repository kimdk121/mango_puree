package com.mangopuree.movie.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieInsertDto {

    private String movieId;
    private String scheduleId;
    private String movieName;
    private String savePath;
    private int fileSize;
}
