package com.StudentManagement.StudentApi.service;

import com.StudentManagement.StudentApi.entity.AttendanceEntity;
import com.StudentManagement.StudentApi.repository.AttendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
    @Autowired
    AttendanceRepo attendanceRepo;

    public AttendanceEntity add(AttendanceEntity attendanceEntity)
    {
        return attendanceRepo.save(attendanceEntity);

    }

}
