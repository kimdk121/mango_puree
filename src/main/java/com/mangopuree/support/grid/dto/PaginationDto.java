package com.mangopuree.support.grid.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PaginationDto {

    private int page;
    private int totalCount;
}
