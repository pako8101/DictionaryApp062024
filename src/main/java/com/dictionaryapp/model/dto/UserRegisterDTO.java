package com.dictionaryapp.model.dto;

import jakarta.validation.constraints.*;

public class UserRegisterDTO {

    @Size(min = 3,max = 20)
    @NotNull
    private String username;
    @Email
    @NotBlank
    private String email;
    @Size(min = 3,max = 20)
    @NotNull
    private String password;
    @Size(min = 3,max = 20)
    @NotNull
    private String confirmPassword;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
