package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // CREATE
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // READ ALL
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // READ BY ID
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // UPDATE
    @Override
    public User updateUser(Long id, User user) {
        User existing = getUserById(id);
        existing.setFullName(user.getFullName());
        existing.setEmail(user.getEmail());
        existing.setRole(user.getRole());
        return userRepository.save(existing);
    }

    // DELETE
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
