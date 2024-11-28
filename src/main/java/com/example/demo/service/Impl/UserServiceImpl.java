package com.example.demo.service.Impl;

import com.example.demo.model.User;
import com.example.demo.repository.InMemoryUserDAO;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final InMemoryUserDAO repository;

    public UserServiceImpl(InMemoryUserDAO repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findUserById(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User update(User user) {
        return repository.update(user);
    }
}
