package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.entity.StudentEntry;
import com.StudentManagement.StudentApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/student")
public class StudentEntryController {

    @Autowired
    private StudentService studentService;

    // Get all
    @GetMapping
    public ResponseEntity<List<StudentEntry>> getAll() {
        List<StudentEntry> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Get one
    @GetMapping("id/{id}")
    public ResponseEntity<StudentEntry> getStudentById(@PathVariable Long id) {
        Optional<StudentEntry> student = studentService.getStudentById(id);
        if (!student.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(student.get());
    }

    // Create
    @PostMapping
    public ResponseEntity<StudentEntry> createEntry(@Valid @RequestBody StudentEntry myEntry) {
        StudentEntry created = studentService.addStudent(myEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // Update
    @PutMapping("id/{id}")
    public ResponseEntity<StudentEntry> updateStudentById(@PathVariable Long id,
                                                          @Valid @RequestBody StudentEntry myEntry) {
        Optional<StudentEntry> existing = studentService.getStudentById(id);
        if (!existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        StudentEntry toUpdate = existing.get();
        toUpdate.setName(myEntry.getName());
        toUpdate.setMobile(myEntry.getMobile());
        toUpdate.setCourse(myEntry.getCourse());
        toUpdate.setBranch(myEntry.getBranch());
        toUpdate.setEmail(myEntry.getEmail());
        StudentEntry updated = studentService.addStudent(toUpdate);
        return ResponseEntity.ok(updated);
    }

    // Delete
    @DeleteMapping("id/{myId}")
    public ResponseEntity<Void> deleteStudentEntryById(@PathVariable Long myId) {
        Optional<StudentEntry> existing = studentService.getStudentById(myId);
        if (!existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        studentService.deleteStudent(myId);
        return ResponseEntity.noContent().build();
    }
}
