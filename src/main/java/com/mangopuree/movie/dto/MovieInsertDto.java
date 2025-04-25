package com.mangopuree.movie.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "영상 등록 DTO")
public class MovieInsertDto {

    @Schema(description = "영상아이디", example = "MOVIE0001")
    private String movieId;

    @Schema(description = "스케쥴아이디", example = "SCHEDULE0002")
    private String scheduleId;

    @Schema(description = "영상명", example = "20250421_080000_5_CAMERA0003.mp4")
    private String movieName;

    @Schema(description = "저장경로", example = "/data/movie/20250421_080000_5_CAMERA0003.mp4")
    private String savePath;

    @Schema(description = "파일크기", example = "2348858")
    private int fileSize;
}
