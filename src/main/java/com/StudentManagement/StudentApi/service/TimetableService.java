package com.StudentManagement.StudentApi.service;

import com.StudentManagement.StudentApi.entity.TimetableEntity;
import com.StudentManagement.StudentApi.repository.TimetableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableService {
    @Autowired
    TimetableRepo timetableRepo;

    public TimetableEntity add(TimetableEntity timetableEntity)
    {
        return timetableRepo.save(timetableEntity);
    }


}
