package com.StudentManagement.StudentApi.Response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Loginresponse {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    private String password;

    public Loginresponse() {
    }

    public Loginresponse(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Loginresponse{name='" + name + "', password='" + password + "'}";
    }
}