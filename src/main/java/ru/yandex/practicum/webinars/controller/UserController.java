package ru.yandex.practicum.webinars.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.webinars.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final List<User> users = new ArrayList<>();
    private int idGenerator = 1;

    @PostMapping()
    public User register(@RequestBody User user) {
        user.setId(idGenerator++);
        users.add(user);
        return user;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }
}
