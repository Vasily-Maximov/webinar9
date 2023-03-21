package ru.yandex.practicum.webinars.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.webinars.model.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final List<User> users = new ArrayList<>();
    private int idGenerator = 1;

    @PostMapping()
    public User register(@RequestBody @Valid User user) {
        if (users.stream().noneMatch(u ->u.getLogin().equals(user.getLogin()))) {
            user.setId(idGenerator++);
            users.add(user);
            log.error("Пользователь с логином {} добавлен", user.getLogin());
            return user;
        } else {
            log.error("Пользователь с логином {} уже существует", user.getLogin());
            throw new RuntimeException("Пользователь с таким логином уже существует!");
        }
    }

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }
}
