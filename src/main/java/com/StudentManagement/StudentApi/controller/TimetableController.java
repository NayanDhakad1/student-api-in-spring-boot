package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.entity.TimetableEntity;
import com.StudentManagement.StudentApi.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/timetable")
@RestController
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @PostMapping("/add")
    public ResponseEntity<TimetableEntity> add(@Valid @RequestBody TimetableEntity timetableEntity) {
        TimetableEntity created = timetableService.add(timetableEntity);
        return ResponseEntity.ok(created);
    }
}

