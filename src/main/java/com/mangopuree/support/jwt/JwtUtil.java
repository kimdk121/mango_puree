package com.mangopuree.support.jwt;

import com.mangopuree.user.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtUtil {

    // 비밀키
    private final SecretKey secretKey;
    // 토큰 유효시간 1시간
    private static final long EXPIRATION_MS = 3600_000;

    public JwtUtil(@Value("${jwt.key}") String key) {
        this.secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 토큰 생성
     * @param userId
     * @return 토큰 문자열
     */
    public String generateToken(String userId) {
        return Jwts.builder()
                .claim("userId", userId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() +EXPIRATION_MS))
                .signWith(secretKey)
                .compact();
    }

    /**
     * token 검증할 JWT 토큰
     * @param token
     * @return String userId
     */
    public String validateAndGetUsername(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.get("userId", String.class);
    }

}
