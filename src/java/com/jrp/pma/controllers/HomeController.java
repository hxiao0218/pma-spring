package com.jrp.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.dto.ProjectStatus;
import com.jrp.pma.entities.Project;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;

@Controller
public class HomeController {
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;

	
	@GetMapping
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", ver);
		
		Map<String, Object> map = new HashMap<>();
		
		// return all the projects in the database
		List<Project> projects = proService.getAll();
		model.addAttribute("projectList", projects);
		
	
		List<ProjectStatus> projectData = proService.getProjectStatus();
		// convert projectData into a JSON structure for use in JS
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString = objMapper.writeValueAsString(projectData);
		model.addAttribute("projectStatusCnt", jsonString);
		
		List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
		model.addAttribute("employeeListProjectsCnt", employeesProjectCnt);
		
		
		return "main/home";
	}
}
