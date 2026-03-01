package com.StudentManagement.StudentApi.repository;

import com.StudentManagement.StudentApi.entity.TimetableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepo extends JpaRepository <TimetableEntity , Long> {
}
