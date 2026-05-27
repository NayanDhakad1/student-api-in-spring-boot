package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.entity.AssignmentsEntity;
import com.StudentManagement.StudentApi.repository.AssignmentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/assignment")
@CrossOrigin(origins = "http://localhost:5173")
public class AssignmentController {

    private final AssignmentRepository repo;

    public AssignmentController(AssignmentRepository repo) {
        this.repo = repo;
    }

    // 🔹 GET ALL
    @GetMapping
    public List<AssignmentsEntity> getAllAssignments() {
        return repo.findAll();
    }

    // 🔹 GET BY ID
    @GetMapping("/{id}")
    public AssignmentsEntity getAssignmentById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id " + id));
    }

    // 🔹 ADD
    @PostMapping
    public AssignmentsEntity addAssignment(@RequestBody AssignmentsEntity assignment) {
        return repo.save(assignment);
    }

    // 🔹 UPDATE
    @PutMapping("/{id}")
    public AssignmentsEntity updateAssignment(@PathVariable Long id,
                                              @RequestBody AssignmentsEntity newData) {

        AssignmentsEntity a = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id " + id));

        a.setTitle(newData.getTitle());
        a.setDescription(newData.getDescription());
        a.setSubject(newData.getSubject());
        a.setDueDate(newData.getDueDate());

        return repo.save(a);
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public String deleteAssignment(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }
}