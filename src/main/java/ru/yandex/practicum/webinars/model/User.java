package ru.yandex.practicum.webinars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class User {
    @Null(groups = CreateGroup.class)
    @NotNull(groups = UpdateGroup.class)
    private Integer id;
    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class})
    private String login;
    @Email(groups = {CreateGroup.class, UpdateGroup.class})
    private String email;
    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class})
    @Size(min = 8, max = 16, groups = {CreateGroup.class, UpdateGroup.class})
    private String password;
}
