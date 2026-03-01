package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.entity.TimetableEntity;
import com.StudentManagement.StudentApi.repository.TimetableRepo;
import com.StudentManagement.StudentApi.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/timetable")
@RestController
public class TimetableController {

    @Autowired
    TimetableService timetableService;

@PostMapping("/add")

public TimetableEntity add(@RequestBody TimetableEntity timetableEntity)
{
    return timetableService.add(timetableEntity);
}


}
