package com.StudentManagement.StudentApi.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
//package com.example.PahlaProject.Entity;
@Entity
public class EmailRequest {
    @Id
    private String email;
    private int otp;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getOtp() {
        return otp;
    }
    public void setOtp(int otp) {
        this.otp = otp;
    }
}

