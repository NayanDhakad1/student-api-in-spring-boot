package com.StudentManagement.StudentApi.repository;

import com.StudentManagement.StudentApi.controller.Regiteacher;
import com.StudentManagement.StudentApi.entity.Registerteacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Regiteachrepo extends JpaRepository<Registerteacher, Long> {
}
