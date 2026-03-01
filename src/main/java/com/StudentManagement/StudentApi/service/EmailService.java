package com.StudentManagement.StudentApi.service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.StudentManagement.StudentApi.entity.EmailRequest;
import com.StudentManagement.StudentApi.repository.OtpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Random;
@Service
public class EmailService {
    @Autowired
    private OtpRepo otpRepo;
    @Autowired
    private JavaMailSender mailSender;
    //senotp
    public String sendOtp(String email) {
        int otp = new Random().nextInt(900000) + 100000;
        EmailRequest request = new EmailRequest();
        request.setEmail(email);
        request.setOtp(otp);
        otpRepo.save(request);
        sendEmail(email, otp);
        return "OTP sent successfully";
    }
    //verifyotp
    public String verifyOtp(String email, int otp) {
        Optional<EmailRequest> optionalOtp = otpRepo.findByEmail(email);
        if (optionalOtp.isPresent()) {
            if (optionalOtp.get().getOtp() == otp) {   //int compare
                return "OTP Verified Successfully";
            } else {
                return "Invalid OTP";
            }
        } else {
            return "Email not found";
        }
    }
    //SENDEMAIL
    public void sendEmail(String toEmail, int otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP is: " + otp);
        mailSender.send(message);
    }
}

