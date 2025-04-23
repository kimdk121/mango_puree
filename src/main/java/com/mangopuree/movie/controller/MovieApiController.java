package com.mangopuree.movie.controller;

import com.mangopuree.movie.service.MovieService;
import com.mangopuree.support.hdfs.HdfsUtils;
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

    private final MovieService movieService;
    private final HdfsUtils hdfsUtils;

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadMovie(@RequestParam String path, String movieName) {
        byte[] fileBytes = hdfsUtils.downloadFromHdfs(path);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ movieName +"\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                .body(new ByteArrayResource(fileBytes));
    }
}
