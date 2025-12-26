package com.example.demo.service.impl;

import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;

public class UserServiceImpl {
    private final UserRepository repo;
    private final BCryptPasswordEncoder enc;
    private final JwtUtil jwt;

    public UserServiceImpl(UserRepository r, BCryptPasswordEncoder e, JwtUtil j){
        repo=r; enc=e; jwt=j;
    }

    public User register(User u){
        if(u==null) throw new RuntimeException();
        if(repo.existsByEmail(u.getEmail())) throw new RuntimeException();
        u.setPassword(enc.encode(u.getPassword()));
        return repo.save(u);
    }

    public AuthResponse login(String email,String pw){
        User u=repo.findByEmail(email).orElseThrow();
        if(!enc.matches(pw,u.getPassword())) throw new RuntimeException();
        return new AuthResponse(jwt.generateToken(new HashMap<>(),email));
    }

    public User findByEmail(String e){
        return repo.findByEmail(e).orElse(null);
    }
}
