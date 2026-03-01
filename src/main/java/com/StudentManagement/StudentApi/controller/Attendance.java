package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.entity.AttendanceEntity;
import com.StudentManagement.StudentApi.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class Attendance {
@Autowired
    AttendanceService attendanceService;

    @PostMapping("/add")
    public AttendanceEntity add(@RequestBody AttendanceEntity attendanceEntity)
    {
        return attendanceService.add(attendanceEntity);
    }
}
