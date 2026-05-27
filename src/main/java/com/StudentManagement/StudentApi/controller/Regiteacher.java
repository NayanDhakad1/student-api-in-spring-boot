package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.entity.Registerteacher;
import com.StudentManagement.StudentApi.repository.Regiteachrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/register")
public class Regiteacher {

    @Autowired
    private Regiteachrepo regiteachrepo;

    @PostMapping("/add")
    public ResponseEntity<Registerteacher> register(@Valid @RequestBody Registerteacher registerteacher) {
        Registerteacher created = regiteachrepo.save(registerteacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Registerteacher>> getAllTeachers() {
        List<Registerteacher> teachers = regiteachrepo.findAll();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Registerteacher> getTeacher(@PathVariable Long id) {
        Optional<Registerteacher> teacher = regiteachrepo.findById(id);
        if (!teacher.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(teacher.get());
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteStudentEntryById(@PathVariable Long id) {
        if (!regiteachrepo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        regiteachrepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/id/{id}")
    public Registerteacher updateTeacher(@PathVariable Long id,
                                         @RequestBody Registerteacher teacherDetails) {

        Registerteacher teacher = regiteachrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        teacher.setName(teacherDetails.getName());
        teacher.setMobile(teacherDetails.getMobile());
        teacher.setEmail(teacherDetails.getEmail());
        teacher.setSubject(teacherDetails.getSubject());
        teacher.setAddress(teacherDetails.getAddress());

        return regiteachrepo.save(teacher);
    }



}
