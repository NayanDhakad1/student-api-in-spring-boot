package com.StudentManagement.StudentApi.service;

import com.StudentManagement.StudentApi.entity.EmailRequest;
import com.StudentManagement.StudentApi.repository.OtpRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private OtpRepo otpRepo;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    private final SecureRandom random = new SecureRandom();

    // SEND OTP
    public String sendOtp(String email) {

        try {
            // Generate 6-digit OTP
            int otp = random.nextInt(900000) + 100000;

            // Create OTP request
            EmailRequest request = new EmailRequest();
            request.setEmail(email);
            request.setOtp(otp);

            // Save OTP in database
            otpRepo.save(request);

            // Send OTP email
            sendEmail(email, otp);

            System.out.println("OTP email sent successfully to: " + email);

            return "OTP sent successfully";

        } catch (MailException e) {

            System.err.println("========== OTP EMAIL FAILED ==========");
            e.printStackTrace();

            Throwable cause = e.getCause();

            while (cause != null) {
                System.err.println(
                        "ROOT CAUSE: " + cause.getClass().getName()
                );
                System.err.println(
                        "ROOT MESSAGE: " + cause.getMessage()
                );

                cause = cause.getCause();
            }

            throw new RuntimeException(
                    "Failed to send OTP email: " + e.getMessage(), e
            );

        } catch (Exception e) {

            System.err.println("========== OTP PROCESSING FAILED ==========");
            e.printStackTrace();

            throw new RuntimeException(
                    "Unable to process OTP: " + e.getMessage(), e
            );
        }
    }

    // VERIFY OTP
    public String verifyOtp(String email, int otp) {

        Optional<EmailRequest> optionalOtp = otpRepo.findByEmail(email);

        if (optionalOtp.isPresent()) {

            EmailRequest savedRequest = optionalOtp.get();

            if (savedRequest.getOtp() == otp) {
                return "OTP Verified Successfully";
            } else {
                return "Invalid OTP";
            }

        } else {
            return "Email not found";
        }
    }

    // SEND EMAIL
    public void sendEmail(String toEmail, int otp) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(senderEmail);
        message.setTo(toEmail);

        message.setSubject(
                "Student Management System - OTP Verification"
        );

        message.setText(
                "Hello,\n\n" +
                        "Your OTP verification code is: " + otp + "\n\n" +
                        "Please do not share this code with anyone.\n\n" +
                        "If you did not request this OTP, please ignore this email.\n\n" +
                        "Regards,\n" +
                        "Student Management System"
        );

        mailSender.send(message);
    }
}