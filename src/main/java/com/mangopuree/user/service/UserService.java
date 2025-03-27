package com.mangopuree.user.service;

import com.mangopuree.user.dto.UserDto;
import com.mangopuree.user.dto.UserSignupDto;
import com.mangopuree.user.dto.UserUpdateDto;
import com.mangopuree.user.dto.UserPasswordUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public boolean existsByUsername(String username) {
        return userMapper.existsByUsername(username);
    }

    public int insertUser(UserSignupDto userSignupDto) {
        userSignupDto.setPassword(passwordEncoder.encode(userSignupDto.getPassword()));
        return userMapper.insertUser(userSignupDto);
    }

    public List<UserDto> findAll() {
        return userMapper.findAll();
    }

    public UserDto findByUserId(String userId) {
        return userMapper.findByUserId(userId);
    }

    public int updateByUserId(UserUpdateDto userUpdateDto) {
        return userMapper.updateByUserId(userUpdateDto);
    }

    public int updatePasswordByUserId(UserPasswordUpdateDto userPasswordUpdateDto) {
        userPasswordUpdateDto.setPassword(passwordEncoder.encode(userPasswordUpdateDto.getPassword()));
        return userMapper.updatePasswordByUserId(userPasswordUpdateDto);
    }
}
