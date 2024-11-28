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

    public User findUserById(Long id) {
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User update(User user) {
        var userIndex = IntStream.range(0, USERS.size())
                .filter(i -> USERS.get(i).getId().equals(user.getId()))
                .findFirst()
                .orElse(-1);

        if (userIndex != -1) {
            USERS.set(userIndex, user);
        }
        return null;
    }


    public void deleteById(Long id) {
        var user = findUserById(id);
        if (user != null) {
            USERS.remove(user);
        }
    }
}
