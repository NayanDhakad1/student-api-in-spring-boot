package com.StudentManagement.StudentApi.repository;
import com.StudentManagement.StudentApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}