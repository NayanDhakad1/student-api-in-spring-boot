package com.StudentManagement.StudentApi.service;
import com.StudentManagement.StudentApi.entity.StudentEntry;
import com.StudentManagement.StudentApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    // Add Student
    public StudentEntry addStudent(StudentEntry studentEntry) {
        return studentRepository.save(studentEntry);
    }
    // Get All Students
    public List<StudentEntry> getAllStudents() {
        return studentRepository.findAll();
    }
    // Get Student By Id
    public Optional<StudentEntry> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    // Delete Student
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student Deleted Successfully";
    }
    // Update Student
    public StudentEntry updateStudent(Long id, StudentEntry studentEntry) {
        studentEntry.setId(id);
        return studentRepository.save(studentEntry);
    }
}
