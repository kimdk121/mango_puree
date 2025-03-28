package com.mangopuree.user.service;

import com.mangopuree.user.dto.UserDto;
import com.mangopuree.user.dto.UserPasswordUpdateDto;
import com.mangopuree.user.dto.UserSignupDto;
import com.mangopuree.user.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    /**
     * 사용자가 존재하는지 조회
     * @param username
     * @return boolean
     */
    public boolean existsByUsername(String username) {
        return userMapper.existsByUsername(username);
    }

    /**
     * 사용자등록
     * @param userSignupDto
     * @return int
     */
    public int insertUser(UserSignupDto userSignupDto) {
        userSignupDto.setPassword(passwordEncoder.encode(userSignupDto.getPassword()));
        return userMapper.insertUser(userSignupDto);
    }

    /**
     * 사용자 전체조회
     * @return List<UserDto>
     */
    public List<UserDto> findAll() {
        return userMapper.findAll();
    }

    /**
     * 사용자아이디로 사용자조회
     * @param userId
     * @return UserDto
     */
    public UserDto findByUserId(String userId) {
        return userMapper.findByUserId(userId);
    }

    /**
     * 사용자아이디로 사용자수정
     * @param userUpdateDto
     * @return int
     */
    public int updateByUserId(UserUpdateDto userUpdateDto) {
        return userMapper.updateByUserId(userUpdateDto);
    }

    /**
     * 사용자아이디로 비밀번호수정
     * @param userPasswordUpdateDto
     * @return int
     */
    public int updatePasswordByUserId(UserPasswordUpdateDto userPasswordUpdateDto) {
        userPasswordUpdateDto.setPassword(passwordEncoder.encode(userPasswordUpdateDto.getPassword()));
        return userMapper.updatePasswordByUserId(userPasswordUpdateDto);
    }
}
