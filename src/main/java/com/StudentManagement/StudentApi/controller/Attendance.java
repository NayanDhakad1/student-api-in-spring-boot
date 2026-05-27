package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.entity.AttendanceEntity;
import com.StudentManagement.StudentApi.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/attendance")
public class Attendance {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/add")
    public ResponseEntity<AttendanceEntity> add(@Valid @RequestBody AttendanceEntity attendanceEntity) {
        AttendanceEntity created = attendanceService.add(attendanceEntity);
        return ResponseEntity.ok(created);
    }
}

