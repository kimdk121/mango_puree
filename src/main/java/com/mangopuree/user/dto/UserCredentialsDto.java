package com.mangopuree.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCredentialsDto {

    private String userId;
    private String username;
    private String password;
    private String name;
    private String roleName;
}
