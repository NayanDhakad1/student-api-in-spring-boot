package com.StudentManagement.StudentApi.Response;
public class Loginresponse {
    private String name;
    private String password;
    public Loginresponse() {
    }
    public Loginresponse(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}