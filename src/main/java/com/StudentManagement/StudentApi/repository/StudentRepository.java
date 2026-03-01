package com.StudentManagement.StudentApi.repository;
import com.StudentManagement.StudentApi.entity.StudentEntry;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<StudentEntry, Long> {
}

//Database se baat karta hai
//Usually:
//extends JpaRepository<StudentEntry, Long>
//Kaam
//findAll()
//save()
//delete()
//findById()
//Repository = Database access layer