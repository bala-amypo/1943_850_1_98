package com.example.demo.service.impl;

import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

public class UserServiceImpl {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserRepository repo, BCryptPasswordEncoder enc, JwtUtil jwt) {
        this.userRepository = repo;
        this.encoder = enc;
        this.jwtUtil = jwt;
    }

    public User register(User user) {
        if (user == null || user.getEmail() == null) {
            throw new RuntimeException();
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException();
        }
        if (user.getRole() == null) {
            user.setRole("LEARNER");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public AuthResponse login(String email, String password) {
        User u = userRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);

        if (!encoder.matches(password, u.getPassword())) {
            throw new RuntimeException();
        }

        String token = jwtUtil.generateToken(new HashMap<>(), email);
        return new AuthResponse(token, u.getId(), u.getEmail(), u.getRole());
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(RuntimeException::new);
    }
}
