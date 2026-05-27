package com.StudentManagement.StudentApi.service;
import com.StudentManagement.StudentApi.entity.User;
import com.StudentManagement.StudentApi.repository.UserRepository;
import com.StudentManagement.StudentApi.Response.Loginresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    // Register User
    public User registerUser(User user) {
        return userRepository.save(user);
    }
    // Login User (Name + Password)
    public Boolean loginUser(Loginresponse loginresponse) {
        // Find user by name
        Optional<User> optionalUser =
                userRepository.findByName(loginresponse.getName());
        if (!optionalUser.isPresent()) {
            return false;
        }
        User user = optionalUser.get();
        // Password match karo
        if (!user.getPassword().equals(loginresponse.getPassword())) {
            return false;
        }
        return true; // Login success
    }
}