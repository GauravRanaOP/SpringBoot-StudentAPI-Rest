package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentrepo;
	private ProjectRepository projectrepo;
	
	public StudentService(StudentRepository studentrepo, ProjectRepository projectrepo) {
        this.studentrepo = studentrepo;
        this.projectrepo = projectrepo;
    }
	
    /** Create a new Student */
	public ResponseEntity<Object> createUser(Student model) {
        Student student = new Student();
        if (studentrepo.findByEmail(model.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("The Email is already Present, Failed to Create new User");
        } else {
        	student.setFirstName(model.getFirstName());
        	student.setLastName(model.getLastName());
        	student.setMobile(model.getMobile());
        	student.setEmail(model.getEmail());
        	student.setRoles(model.getRoles());

        	Student savedUser = studentrepo.save(student);
            if (studentrepo.findById(savedUser.getId()).isPresent())
                return ResponseEntity.ok("User Created Successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
        }
    }
	
}
