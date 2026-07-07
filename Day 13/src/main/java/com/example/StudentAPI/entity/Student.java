package com.example.StudentAPI.entity;

import jakarta.persistence.Entity;

@Entity
public class Student {

    private int rollNo;
    private String name;

    public Student(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}