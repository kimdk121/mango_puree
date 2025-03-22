package com.mangopuree.user.service;

import com.mangopuree.user.dto.UserSignupDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
}
