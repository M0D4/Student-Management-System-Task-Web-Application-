package com.studentmanagementtask.studentmanagementtaskapi.rest;


import com.studentmanagementtask.studentmanagementtaskapi.entity.Student;
import com.studentmanagementtask.studentmanagementtaskapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService){
        this.studentService = studentService;
    }



    //expose "/students" to return all students
    @GetMapping("/students")
    public List<Student> getAll(){
        return studentService.getAll();
    }

    //mapping for "/students/{studentNationalIDOrName}
    @GetMapping("/students/{s}")
    public List<Student> getByIdOrName(@PathVariable String s){
        List<Student> students = studentService.getByIdOrName(s);
        return students;
    }

    //mapping for post "/students"
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        if(studentService.getByIdOrName(student.getNationalID()).size() != 0){
            throw new RuntimeException("Duplicate National ID number!");
        }
        studentService.save(student);
        return student;
    }

    //mapping for update "/student"
    @PutMapping("/students/{studentID}")
    public Student updateStudent(@PathVariable String studentID, @RequestBody Student student){
        /*if(studentService.getByIdOrName(studentID).size() != 1){
            throw new RuntimeException("This national ID is not assigned to any student!");
        }*/
        studentService.update(studentID, student);
        return student;
    }

    //mapping for delete "students/{studentID}"
    @DeleteMapping("/students/{studentID}")
    public Student deleteStudent(@PathVariable String studentID){
        if(studentService.getByIdOrName(studentID).size() != 1){
            throw new RuntimeException("This national ID is not assigned to any student!");
        }
        Student student = studentService.getByIdOrName(studentID).get(0);
        studentService.delete(studentID);
        return student;
    }
}
