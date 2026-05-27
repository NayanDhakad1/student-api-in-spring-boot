package com.StudentManagement.StudentApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
public class StudentEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotBlank(message = "Mobile is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile must be a 10-digit number")
    private String mobile;

    @NotBlank(message = "Course is required")
    @Size(max = 100, message = "Course must be at most 100 characters")
    private String course;

    @NotBlank(message = "Branch is required")
    @Size(max = 100, message = "Branch must be at most 100 characters")
    private String branch;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column(unique = true)
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