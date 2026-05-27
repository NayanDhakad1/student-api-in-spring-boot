package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.Response.Loginresponse;
import com.StudentManagement.StudentApi.entity.User;
import com.StudentManagement.StudentApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User created = userService.registerUser(user);
        return ResponseEntity.ok(created);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody Loginresponse loginresponse, org.springframework.validation.BindingResult result) {
        // log what we received for debugging
        System.out.println("login payload: " + loginresponse);
        if (result.hasErrors()) {
            // collect error messages and return them
            java.util.List<String> errors = new java.util.ArrayList<>();
            result.getAllErrors().forEach(e -> errors.add(e.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        Boolean success = userService.loginUser(loginresponse);
        return ResponseEntity.ok(success);
    }
}