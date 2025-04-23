package com.mangopuree.support.grid.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SetGridDataDto <T>{

    private List<T> contents;
    private PaginationDto pagination;
}
