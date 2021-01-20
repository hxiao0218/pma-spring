package com.jrp.pma.services;

import java.util.List;

import com.jrp.pma.dao.IEmployeeRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

//@Service
public class EmployeeService {
	IEmployeeRepository empRepo;
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public List<Employee> getAll() {
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}


//	// setter injection
//	@Autowired
//	public void setEmpRepo(IEmployeeRepository empRepo) {
//		this.empRepo = empRepo;
//	}
//	
	
	
//	// constructor injection
//	public EmployeeService(IEmployeeRepository empRepo) {
//		super();
//		this.empRepo = empRepo;
//	}

}