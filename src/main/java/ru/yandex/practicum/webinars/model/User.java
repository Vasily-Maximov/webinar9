package ru.yandex.practicum.webinars.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class User {
    @Null
    private Integer id;
    @NotBlank
    private String login;
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, max = 16)
    private String password;
}
