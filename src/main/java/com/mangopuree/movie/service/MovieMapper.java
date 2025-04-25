package com.mangopuree.movie.service;

import com.mangopuree.movie.dto.MovieInsertDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieMapper {

    /**
     * 다음 저장할 영상아이디 조회
     * @return String
     */
    String findNextMovieId();

    /**
     * 등록
     * @param movieInsertDto
     * @return insert
     */
    int insert(MovieInsertDto movieInsertDto);
}
