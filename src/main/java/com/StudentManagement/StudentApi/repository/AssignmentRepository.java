package com.StudentManagement.StudentApi.repository;



import com.StudentManagement.StudentApi.entity.AssignmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<AssignmentsEntity, Long> {
}
