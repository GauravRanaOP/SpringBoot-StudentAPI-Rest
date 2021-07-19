package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	private StudentService studentService;
    private StudentRepository studentRepository;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }
    //
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody Student student) {
        return studentService.createUser(student);
    }
    
    @GetMapping("/user/details/{id}")
    public Student getUser(@PathVariable Long id) {
        if(studentRepository.findById(id).isPresent())
            return studentRepository.findById(id).get();
        else return  null;
    }
    @GetMapping("/user/all")
    public List<Student> getUsers() {
        return studentRepository.findAll();
    }
}
