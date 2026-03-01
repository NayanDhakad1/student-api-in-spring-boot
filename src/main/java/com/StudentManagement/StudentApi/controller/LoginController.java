package com.StudentManagement.StudentApi.controller;
import com.StudentManagement.StudentApi.Response.Loginresponse;
import com.StudentManagement.StudentApi.entity.User;
import com.StudentManagement.StudentApi.service.UserService;
//import com.StudentManagement.StudentApi.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/ram")
    public String fun() {
        return "fun";
    }
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public boolean loginUser(@RequestBody Loginresponse loginresponse) {
        return userService.loginUser(loginresponse);
    }
}
