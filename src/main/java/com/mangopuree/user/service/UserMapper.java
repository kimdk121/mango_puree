package com.mangopuree.user.service;

import com.mangopuree.user.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 유저명으로 사용자정보 조회
     * @param username
     * @return UserCredentialsDto
     */
    UserCredentialsDto findUserCredentialsByUsername(String username);

    /**
     * 사용자가 존재하는지 조회
     * @param username
     * @return boolean
     */
    boolean existsByUsername(String username);

    /**
     * 사용자등록
     * @param userSignupDto
     * @return int
     */
    int insertUser(UserSignupDto userSignupDto);

    /**
     * 사용자 전체조회
     * @return List<UserDto>
     */
    List<UserDto> findAll();

    /**
     * 사용자아이디로 사용자조회
     * @param userId
     * @return UserDto
     */
    UserDto findByUserId(String userId);

    /**
     * 사용자아이디로 사용자수정
     * @param userUpdateDto
     * @return int
     */
    int updateByUserId(UserUpdateDto userUpdateDto);

    /**
     * 사용자아이디로 비밀번호수정
     * @param userPasswordUpdateDto
     * @return int
     */
    int updatePasswordByUserId(UserPasswordUpdateDto userPasswordUpdateDto);
}
