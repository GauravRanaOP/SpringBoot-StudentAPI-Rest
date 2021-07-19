package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {

	  private ProjectRepository projectrepo;

	    public ProjectService(ProjectRepository projectrepo) {
	        this.projectrepo = projectrepo;
	    }
	    
	    /** Create a new role  */
	    public ResponseEntity<Object> addRole(Project project)  {

	    	Project newProject = new Project();
	    	newProject.setName(project.getName());
	    	newProject.setDescription(project.getDescription());
	        Project savedRole = projectrepo.save(newProject);
	        if(projectrepo.findById(savedRole.getId()).isPresent()) {
	            return ResponseEntity.accepted().body("Successfully Created Role ");
	        } else
	            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
	    }
}
