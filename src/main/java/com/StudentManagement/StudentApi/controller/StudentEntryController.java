package com.StudentManagement.StudentApi.controller;
import com.StudentManagement.StudentApi.entity.StudentEntry;
import com.StudentManagement.StudentApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")  //frontend backed ko call krta h
@RestController //Ye batata hai ki ye class ek REST API controller hai Ye JSON data return karega (HTML page nahi).
@RequestMapping("/student")
public class StudentEntryController {
    @Autowired
    private StudentRepository studentRepository;
    // Get all
    @GetMapping
    public List<StudentEntry> getAll()
    {
        return studentRepository.findAll();
    }
    // Get one
    @GetMapping("id/{id}")
    public StudentEntry getStudentById(@PathVariable Long id)
    {
        return studentRepository.findById(id).orElse(null);
    }
    // Create
    @PostMapping
    public StudentEntry createEntry(@RequestBody StudentEntry myEntry) {
        return studentRepository.save(myEntry);
    }
    // Update
    @PutMapping("id/{id}")
    public StudentEntry updateStudentById(@PathVariable Long id, @RequestBody StudentEntry myEntry) {
        StudentEntry existing = studentRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setName(myEntry.getName());
        existing.setMobile(myEntry.getMobile());
        existing.setCourse(myEntry.getEmail());
        existing.setCourse(myEntry.getCourse());
        existing.setBranch(myEntry.getBranch());
        return studentRepository.save(existing);
    }
    // Delete
    @DeleteMapping("id/{myId}")
    public Boolean deleteStudentEntryById(@PathVariable Long myId) {
        if (!studentRepository.existsById(myId)) return Boolean.FALSE;
        studentRepository.deleteById(myId);
        return Boolean.TRUE;
    }
}
//Frontend se request lena
//URL mapping karna
//Response bhejna (JSON)