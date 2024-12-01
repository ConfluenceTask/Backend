package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/main")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/find/{name}")
    public User findById(@PathVariable String name) {
        return userService.findByUsername(name);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/delete/{name}")
    public void delete(@PathVariable String userName) {
        userService.deleteByUsername(userName);
    }
}
