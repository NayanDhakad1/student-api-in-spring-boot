package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.entity.EmailRequest;
import com.StudentManagement.StudentApi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Otp")
@RestController
public class OtpController {

    @Autowired
    private EmailService emailService;

    @GetMapping("get")
    public String get() {
        return "get";
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@Valid @RequestBody EmailRequest emailRequest) {
        String result = emailService.sendOtp(emailRequest.getEmail());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@Valid @RequestBody EmailRequest emailRequest) {
        String result = emailService.verifyOtp(
                emailRequest.getEmail(),
                emailRequest.getOtp()
        );
        return ResponseEntity.ok(result);
    }
}

