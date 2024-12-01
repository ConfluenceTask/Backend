package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryUserDAO {
    private final List<User> USERS = new ArrayList<>();

    public List<User> findAll() {
        return USERS;
    }

    public User save(User user) {
        USERS.add(user);
        return user;
    }

    public User findUserByUsername(String username) {
        return USERS.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public User update(User user) {
        var userIndex = IntStream.range(0, USERS.size())
                .filter(i -> USERS.get(i).getUsername().equals(user.getUsername()))
                .findFirst()
                .orElse(-1);

        if (userIndex != -1) {
            USERS.set(userIndex, user);
        }
        return null;
    }


    public void deleteByUsername(String username) {
        var user = findUserByUsername(username);
        if (user != null) {
            USERS.remove(user);
        }
    }

    public boolean authenticate(String login, String password) {
        return USERS.stream()
                .anyMatch(u -> u.getUsername().equals(login) &&
                        u.getPassword().equals(password));
    }
}
