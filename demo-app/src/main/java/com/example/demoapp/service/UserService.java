package com.example.demoapp.service;

import com.example.demoapp.annotation.LogUserActivity;
import com.example.demoapp.dto.CreateUserRequest;
import com.example.demoapp.entity.User;
import com.example.demoapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @LogUserActivity
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }
}
