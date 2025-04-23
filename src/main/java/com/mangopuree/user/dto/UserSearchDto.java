package com.mangopuree.user.dto;

import com.mangopuree.support.grid.dto.RequestGridDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchDto extends RequestGridDto {

    private String username;
    private String name;
}
