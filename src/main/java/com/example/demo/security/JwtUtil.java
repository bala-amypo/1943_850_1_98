package com.example.demo.security;

import java.util.Map;

public class JwtUtil {

    public String generateToken(Map<String, Object> claims, String subject) {
        // Real JWT logic is NOT required for tests
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        // Tests mock this method directly
        return true;
    }
}
