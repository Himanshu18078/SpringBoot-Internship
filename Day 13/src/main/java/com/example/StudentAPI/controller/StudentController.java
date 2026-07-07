package com.example.StudentAPI.controller;

import com.example.StudentAPI.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    List<Student> students = new ArrayList<>();

    @PostMapping
    public String createStudent(@RequestBody Student student){
        students.add(student);
        return "Student Added Successfully";
    }

    @GetMapping
    public List<Student> getAllStudent(){ //here spring use jackson library to convert the object into the JSON
        return students;
    }

    @GetMapping("/{rollNo}")
    public Student getStudent(@PathVariable int rollNo){
        for(Student s : students){
            if(s.getRollNo() == rollNo){
                return s;
            }
        }
        return null;
    }
    @PutMapping("/{rollNo}")
    public String updateStudent(@PathVariable int rollNo, @RequestBody Student student){
        for(Student s : students){
            if(s.getRollNo() == rollNo){
                s.setName(student.getName());
                return "Student Updated Successfully";
            }
        }
        return "Student Not Found";
    }
    @DeleteMapping("/{rollNo}")
    public String deleteStudent(@PathVariable int rollNo){
        for(Student s : students){
            if(s.getRollNo() == rollNo){
                students.remove(s);
                return "Student Removed Successfully";
            }
        }
        return "Student Not Found";
    }
}