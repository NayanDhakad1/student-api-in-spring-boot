package com.StudentManagement.StudentApi.service;

import com.StudentManagement.StudentApi.entity.Registerteacher;
import com.StudentManagement.StudentApi.repository.Regiteachrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Regiteachservice {
@Autowired
Regiteachrepo regiteachrepo;

public Registerteacher  add(Registerteacher registerteacher)
{
    return regiteachrepo.save(registerteacher);
}

public List<Registerteacher> viewAll()

{
    return regiteachrepo.findAll();
}

}
