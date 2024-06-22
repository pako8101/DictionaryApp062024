package com.dictionaryapp.model.dto;

import jakarta.validation.constraints.*;

public class UserRegisterDTO {

    @Size(min = 3,max = 20,message = "Username must be between 3 and 20 symbols!")
    @NotNull(message = "Username must not be empty!")
    private String username;
    @Email(message = "Email must be valid format!")
    @NotBlank(message = "Email must not be empty!")
    private String email;
    @Size(min = 3,max = 20,message = "Password must be between 3 and 20 symbols!")
    @NotNull(message = "Password must not be empty!")
    private String password;
    @Size(min = 3,max = 20,message = "Password must be between 3 and 20 symbols!")
    @NotNull(message = "Password must not be empty!")
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
