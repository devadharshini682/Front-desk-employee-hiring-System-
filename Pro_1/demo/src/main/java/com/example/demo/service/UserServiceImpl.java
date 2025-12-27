package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user.orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> existing = userRepo.findById(id);
        if (existing.isEmpty()) return null;

        User u = existing.get();
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setRole(user.getRole());
        u.setPhoneNumber(user.getPhoneNumber());
        u.setDepartment(user.getDepartment());
        return userRepo.save(u);
    }
}
