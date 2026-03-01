package com.StudentManagement.StudentApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TimetableEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String teacherName;
private String subject;
private String day;
private Long time;
private String classroom;

public TimetableEntity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }


    public TimetableEntity(Long id, String teacherName, String subject, String day, Long time, String classroom) {
        this.id = id;
        this.teacherName = teacherName;
        this.subject = subject;
        this.day = day;
        this.time = time;
        this.classroom = classroom;
    }
}
