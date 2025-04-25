package com.mangopuree.movie.service;

import com.mangopuree.movie.dto.MovieInsertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieMapper movieMapper;

    /**
     * 다음 저장할 영상아이디 조회
     * @return String
     */
    public String findNextMovieId() {
        return movieMapper.findNextMovieId();
    }

    /**
     *
     * @param movieInsertDto
     * @return int
     */
    public int insert(MovieInsertDto movieInsertDto) {
        return movieMapper.insert(movieInsertDto);
    }
}
