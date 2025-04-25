package com.mangopuree.auth;

import com.mangopuree.auth.dto.AuthRequestDto;
import com.mangopuree.auth.dto.AuthResponseDto;
import com.mangopuree.support.jwt.JwtUtil;
import com.mangopuree.user.service.UserService;
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
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto authRequestDto) {
        if (!userService.existsByUsername(authRequestDto.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        String encodedPassword = userService.findUserCredentialsByUsername(authRequestDto.getUsername()).getPassword();
        if (!passwordEncoder.matches(authRequestDto.getPassword(), encodedPassword)) {
            return ResponseEntity.badRequest().build();
        }

        String token = jwtUtil.generateToken(authRequestDto.getUsername());
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
}
