package com.StudentManagement.StudentApi.repository;

import com.StudentManagement.StudentApi.entity.CreateTimetableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateTimetableRepo extends JpaRepository<CreateTimetableEntity ,Long> {
}
