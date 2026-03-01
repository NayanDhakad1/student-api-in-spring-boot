package com.StudentManagement.StudentApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class StudentEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobile;
    private String course;
    private String branch;
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getMobile() {
        return mobile;
    }
    public String getCourse() {
        return course;
    }
    public String getBranch() {
        return branch;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
}

//Database table ka Java representation.
//Isme hota hai:
//Fields (id, name, age, etc.)
//@Entity annotation
//@Id
//@GeneratedValue
// Ye database table ka model hota hai