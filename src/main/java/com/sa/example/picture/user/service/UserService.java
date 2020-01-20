package com.sa.example.picture.user.service;


import com.sa.example.picture.domain.data.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}