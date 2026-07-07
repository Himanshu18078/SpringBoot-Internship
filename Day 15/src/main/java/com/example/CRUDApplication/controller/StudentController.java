package com.example.CRUDApplication.controller;

import com.example.CRUDApplication.entity.Student;
import com.example.CRUDApplication.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    //Create
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        student.setDeleted(false);
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }
    //Read One Data
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
        Student response = studentService.getStudent(id);
        if(response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    //Read all the data
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> StudentList = studentService.getAllStudent();
        if(StudentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(StudentList);
    }
    //Read One Data
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id,@RequestBody Student studentReq){
        Student response = studentService.updateStudent(id ,  studentReq);
        if(response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
//    DELETE
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        Boolean isDeleted =  studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
        Boolean isDeleted  = studentService.deleteStudentSoftly(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }
}
