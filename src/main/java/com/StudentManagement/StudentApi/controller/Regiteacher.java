package com.StudentManagement.StudentApi.controller;

import com.StudentManagement.StudentApi.entity.Registerteacher;
import com.StudentManagement.StudentApi.repository.Regiteachrepo;
import com.StudentManagement.StudentApi.service.Regiteachservice;
import org.hibernate.hql.spi.id.global.GlobalTemporaryTableBulkIdStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/register")
public class Regiteacher {

@Autowired
Regiteachrepo regiteachrepo;
@PostMapping ("/add")
public Registerteacher register(@RequestBody Registerteacher registerteacher)
{
return regiteachrepo.save(registerteacher);
}

    @GetMapping("/all")
    public List<Registerteacher> getAllTeachers() {
    return regiteachrepo.findAll();
    }

    @GetMapping("/id/{id}")
    public Registerteacher getTeacher(@PathVariable Long id) {
    return regiteachrepo.findById(id).orElse(null);
    }

    @DeleteMapping("id/{id}")
    public Boolean deleteStudentEntryById(@PathVariable Long id) {
        if (!regiteachrepo.existsById(id)) return Boolean.FALSE;
        regiteachrepo.deleteById(id);
        return Boolean.TRUE;
    }


}