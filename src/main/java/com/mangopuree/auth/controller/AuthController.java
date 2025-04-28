package com.mangopuree.auth.controller;

import com.mangopuree.auth.dto.AuthRequestDto;
import com.mangopuree.auth.dto.AuthResponseDto;
import com.mangopuree.support.jwt.JwtUtil;
import com.mangopuree.user.dto.UserCredentialsDto;
import com.mangopuree.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    @Operation(summary = "토큰 발행", description = "아이디 비밀번호를 대조해 토큰을 발행합니다.")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto authRequestDto) {
        if (!userService.existsByUsername(authRequestDto.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        UserCredentialsDto userCredentials = userService.findUserCredentialsByUsername(authRequestDto.getUsername());
        String encodedPassword = userCredentials.getPassword();
        String userId = userCredentials.getUserId();

        if (!passwordEncoder.matches(authRequestDto.getPassword(), encodedPassword)) {
            return ResponseEntity.badRequest().build();
        }

        String token = jwtUtil.generateToken(userId);
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
}
