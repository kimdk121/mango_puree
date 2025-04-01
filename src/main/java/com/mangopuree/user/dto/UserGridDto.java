package com.mangopuree.user.dto;

import com.mangopuree.support.base.dto.ResponseGridDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGridDto extends ResponseGridDto {

    private Long userId;
    private String username;
    private String name;
    private String telNo;
    private String faxNo;
    private String roleName;
    private String regDt;
}
