package com.example.demo.service.Impl;

import com.example.demo.repository.InMemoryUserDAO;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private InMemoryUserDAO repository;

    @Autowired
    public AuthServiceImpl(InMemoryUserDAO repository) {
        this.repository = repository;
    }

    @Override
    public boolean authenticate(String username, String password) {
        return repository.authenticate(username, password);
    }
}
