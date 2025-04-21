package com.mangopuree.movie.service;

import com.mangopuree.movie.dto.MovieInsertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieMapper movieMapper;

    public String findNextMovieId() {
        return movieMapper.findNextMovieId();
    }
    public int insert(MovieInsertDto movieInsertDto) {
        return movieMapper.insert(movieInsertDto);
    }
}
