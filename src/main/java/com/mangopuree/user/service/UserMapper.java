package com.mangopuree.user.service;

import com.mangopuree.user.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserCredentialsDto findUserCredentialsByUsername(String username);

    boolean existsByUsername(String username);

    int insertUser(UserSignupDto userSignupDto);

    List<UserDto> findAll();

    UserDto findByUserId(String userId);

    int updateByUserId(UserUpdateDto userUpdateDto);

    int updatePasswordByUserId(UserPasswordUpdateDto userPasswordUpdateDto);
}
