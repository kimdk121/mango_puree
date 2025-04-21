package com.mangopuree.movie.service;

import com.mangopuree.movie.dto.MovieInsertDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieMapper {

    String findNextMovieId();
    int insert(MovieInsertDto movieInsertDto);
}
