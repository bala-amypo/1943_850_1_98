package com.example.demo.service.impl;

import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthResponse register(String email, String password) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(encoder.encode(password));

        userRepository.save(user);

        return new AuthResponse("REGISTER_SUCCESS");
    }
}
