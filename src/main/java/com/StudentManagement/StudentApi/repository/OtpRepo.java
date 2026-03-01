package com.StudentManagement.StudentApi.repository;
import com.StudentManagement.StudentApi.entity.EmailRequest;
//import com.example.PahlaProject.Entity.EmailRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface OtpRepo extends JpaRepository<EmailRequest, String> {
    Optional<EmailRequest> findByEmail(String email);   // 🔥 Ye line missing thi

}

