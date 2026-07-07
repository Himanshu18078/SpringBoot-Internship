package com.example.CRUDApplication.service;

import com.example.CRUDApplication.entity.Student;
import com.example.CRUDApplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // This is to Create Student
    public Student createStudent(Student studentReq){
        studentReq.setDeleted(false);
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }
    //This is to get Student
    public Student getStudent(Long id){
       Optional<Student> studentResp=  studentRepository.findByIdAndDeletedIsFalse(id);
       if(studentResp.isPresent()){
           return studentResp.get();
       }
       return null;
    }
    //This is to get all the student
    public List<Student> getAllStudent(){
        List<Student> studentList =  studentRepository.findByDeletedIsFalse();
        return studentList;
    }
    //This is to update student
    public Student updateStudent(Long id,Student studentReq){
        Optional<Student> existingStudent =  studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToSave  = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setDeleted(false);
        return studentRepository.save(studentToSave);
    }
    //this is to delete(HARD DELETE)
    public Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id);
        if(!isStudent){
            return false;
        }
        studentRepository.deleteAllById(Collections.singleton(id));
        return true;
    }
    //this is to delete(SOFT DELETE)
    public Boolean deleteStudentSoftly(Long id){
        Optional<Student> exitingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(exitingStudent.isEmpty()){
            return false;
        }
        Student studentToSave = exitingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }
}
