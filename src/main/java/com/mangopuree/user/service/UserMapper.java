package com.mangopuree.user.service;

import com.mangopuree.user.dto.UserCredentialsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserCredentialsDto findUserCredentialsByUsername(String username);
}
