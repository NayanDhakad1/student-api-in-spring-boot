package com.StudentManagement.StudentApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Student name is required")
    private String StudentName;

    @NotBlank(message = "Subject is required")
    private String Subject;

    @NotNull(message = "Date is required")
    private Long Date;

    @NotBlank(message = "Status is required")
    private String Status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public Long getDate() {
        return Date;
    }

    public void setDate(Long date) {
        Date = date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public AttendanceEntity(Long id, String studentName, String subject, Long date, String status) {
        this.id = id;
        StudentName = studentName;
        Subject = subject;
        Date = date;
        Status = status;
    }

    public AttendanceEntity(){}


}
