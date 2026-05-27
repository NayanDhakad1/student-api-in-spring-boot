package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.entity.CreateTimetableEntity;
import com.StudentManagement.StudentApi.service.CreateTimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Createtimetable")
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CreateTimetable {

    @Autowired
    CreateTimetableService createTimetableService;

    @PostMapping("/add")
    public CreateTimetableEntity addTimetable(@RequestBody CreateTimetableEntity createTimetableEntity)
    {
        return createTimetableService.addTimetable(createTimetableEntity);
    }

    @GetMapping("/showall")
    public ResponseEntity<List<CreateTimetableEntity>> showall()
    {
        List<CreateTimetableEntity> createTimetableEntities = createTimetableService.showall();
        return ResponseEntity.ok(createTimetableEntities);
    }

    @GetMapping("/{id}")
    public CreateTimetableEntity getById(@PathVariable Long id)
    {
        return createTimetableService.getById(id);
    }


    @PutMapping("/update/{id}")
    public CreateTimetableEntity updatedata(@PathVariable Long id ,@RequestBody CreateTimetableEntity createTimetableEntity)
    {
        return createTimetableService.updatetimetable(id , createTimetableEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deletebyid(@PathVariable Long id)
    {
        createTimetableService.deletedata(id);
    }


}

