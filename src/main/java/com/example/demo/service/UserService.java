package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByUsername(String username);

    User save(User user);

    void deleteByUsername(String username);

    User update(User user);





}
