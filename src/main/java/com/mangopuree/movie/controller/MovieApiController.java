package com.mangopuree.movie.controller;

import com.mangopuree.movie.service.MovieService;
import com.mangopuree.support.hdfs.HdfsUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
public class MovieApiController {

    private final HdfsUtils hdfsUtils;

    @GetMapping("/download")
    @Operation(summary = "영상 다운로드", description = "하둡에 저장되어 있는 영상을 다운로드합니다.")
    public ResponseEntity<Resource> downloadMovie(@Parameter(description = "경로", example = "/data/movie/20250421_080000_5_CAMERA0003.mp4") @RequestParam String path,
                                                  @Parameter(description = "영상명", example = "20250421_080000_5_CAMERA0003.mp4") @RequestParam String movieName) {
        byte[] fileBytes = hdfsUtils.downloadFromHdfs(path);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ movieName +"\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                .body(new ByteArrayResource(fileBytes));
    }
}
