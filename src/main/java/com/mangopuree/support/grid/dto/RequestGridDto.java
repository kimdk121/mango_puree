package com.mangopuree.support.grid.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestGridDto {

    private int perPage;
    private int page;
    private int offset;
    private int limit;

    public void calculatePaging() {
        this.offset = (page - 1) * perPage;
        this.limit = perPage;
    }
}
