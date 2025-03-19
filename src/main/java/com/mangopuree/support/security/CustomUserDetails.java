package com.mangopuree.support.security;

import com.mangopuree.user.dto.UserCredentialsDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

    private String userId;
    private String password;
    private String userName;
    private String name;

    public CustomUserDetails(UserCredentialsDto user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUserId(), user.getPassword() , authorities);
        this.userId = user.getUserId();
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.name = user.getName();
    }

}