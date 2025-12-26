package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username) {
        return "jwt-token-" + username;
    }

    public String extractUsername(String token) {
        if (token == null) return null;
        return token.replace("jwt-token-", "");
    }

    public boolean validateToken(String token, String username) {
        return token != null && token.equals(generateToken(username));
    }
}
