package ru.yandex.practicum.webinars.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.webinars.model.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<Integer, User> users = new HashMap<>(Map.of(1,new User(1,"Vasiliy","kt-62a@mail.ru",
            "123456789")));
    private int idGenerator = 2;

    @PostMapping()
    public User register(@RequestBody @Valid User user) {
        if (users.values().stream().noneMatch(u ->u.getLogin().equals(user.getLogin()))) {
            user.setId(idGenerator++);
            users.put(user.getId(),user);
            log.error("Пользователь с логином {} добавлен", user.getLogin());
            return user;
        } else {
            log.error("Пользователь с логином {} уже существует", user.getLogin());
            throw new RuntimeException("Пользователь с таким логином уже существует!");
        }
    }

    @DeleteMapping()
    public List<User> cleanUsers() {
        if (! users.containsKey(1)) {
            users.clear();
        } else {
            User userAdmin = users.get(1);
            users.clear();
            users.put(1, userAdmin);
        }
        log.info("Список пользователей очищен");
        return new ArrayList<>(users.values());
    }

    @GetMapping
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
