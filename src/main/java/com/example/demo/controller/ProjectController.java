package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;

@RestController
public class ProjectController {

	 private ProjectService projectService;
	    private ProjectRepository projectRepository;

	    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
	        this.projectService = projectService;
	        this.projectRepository = projectRepository;
	    }
	    
	    @GetMapping("/project/details/{id}")
	    public Project getRole(@PathVariable Long id) {
	        if(projectRepository.findById(id).isPresent())
	            return projectRepository.findById(id).get();
	        else return null;
	    }
	    
	    @GetMapping("/project/all")
	    public List<Project> getRoles() {
	        return projectRepository.findAll();
	    }
}
