package com.mangopuree.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long userId;
    private String username;
    private String name;
    private String telNo;
    private String faxNo;
    private String roleName;
    private String regDt;
}
