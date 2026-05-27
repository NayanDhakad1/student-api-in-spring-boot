package com.StudentManagement.StudentApi.service;

import com.StudentManagement.StudentApi.entity.CreateTimetableEntity;
import com.StudentManagement.StudentApi.repository.CreateTimetableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CreateTimetableService {
    @Autowired
    CreateTimetableRepo createTimetableRepo;

    public CreateTimetableEntity addTimetable( CreateTimetableEntity createTimetableEntity)

    {
        return createTimetableRepo.save(createTimetableEntity);
    }


    public List<CreateTimetableEntity> showall()
    {
        return createTimetableRepo.findAll();
    }


    public CreateTimetableEntity getById(Long id)
    {
        return createTimetableRepo.findById(id).orElse(null);
    }

    public CreateTimetableEntity updatetimetable(Long id ,CreateTimetableEntity newdata)
    {
        CreateTimetableEntity olddata =createTimetableRepo.findById(id).orElse(null);
        if (olddata != null)
        {
            olddata.setTeacher(newdata.getTeacher());
            olddata.setSubject(newdata.getSubject());
            olddata.setTime(newdata.getTime());
            olddata.setDay(newdata.getDay());

            return createTimetableRepo.save(olddata);
        }
        return null;
    }


    public String deletedata(Long id)
    {
        createTimetableRepo.deleteById(id);
        return "delete success";
    }

}
