package com.mangopuree.user.service;

import com.mangopuree.user.dto.UserCredentialsDto;
import com.mangopuree.user.dto.UserSignupDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.exceptions.PersistenceException;

@Mapper
public interface UserMapper {

    UserCredentialsDto findUserCredentialsByUsername(String username);

    boolean existsByUsername(String username);

    int insertUser(UserSignupDto userSignupDto);
}
