package com.StudentManagement.StudentApi.repository;

import com.StudentManagement.StudentApi.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepo extends JpaRepository<AttendanceEntity , Long> {
}
