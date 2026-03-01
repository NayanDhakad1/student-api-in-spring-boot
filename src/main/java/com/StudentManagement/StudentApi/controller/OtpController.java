package com.StudentManagement.StudentApi.controller;
import com.StudentManagement.StudentApi.entity.EmailRequest;
import com.StudentManagement.StudentApi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Otp")
@RestController
public class OtpController
{
    @Autowired
    EmailService emailService;
    @GetMapping("get")
    public  String get()
    {
        return "get";
    }
    @PostMapping("/send")
    public String sendOtp(@RequestBody EmailRequest emailRequest)
    {
        return emailService.sendOtp(emailRequest.getEmail());
    }
    @PostMapping("/verify")
    public String verifyOtp(@RequestBody EmailRequest emailRequest)
    {
        return emailService.verifyOtp(
                emailRequest.getEmail(),
                emailRequest.getOtp()
        );
    }
}
