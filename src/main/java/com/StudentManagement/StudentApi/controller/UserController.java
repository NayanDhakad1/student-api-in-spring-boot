package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.entity.Employee;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserController {

    private final List<Employee> list = new ArrayList<>();

    {
        list.add(new Employee(101, "nayan", 21));
    }

    @GetMapping("/user")
    public String user() {
        return "user password";
    }

    @GetMapping("/Employee")
    public List<Employee> getEmployees() {
        return list;
    }

    @PostMapping("/Employee")
    public void add(@Valid @RequestBody Employee employee) {
        list.add(employee);
    }

    @GetMapping("/csrf")
    public CsrfToken session(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}

