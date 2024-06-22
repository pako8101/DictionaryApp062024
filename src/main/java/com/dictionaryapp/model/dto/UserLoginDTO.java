package com.dictionaryapp.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {
    @NotBlank(message = "Username must not be empty!")
    @Size(min = 3, max = 20,message = "Username must be between 3 and 20 symbols!")
    private String username;
    @NotBlank(message = "Password must not be empty!")
    @Size(min = 3, max = 20,message = "Password must be between 3 and 20 symbols!")
    private String password;

    public UserLoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
