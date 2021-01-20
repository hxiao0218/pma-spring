package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.ProjectStatus;
import com.jrp.pma.entities.Project;

public interface IProjectRepository extends CrudRepository<Project, Long>{

	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value FROM project GROUP BY stage")
	public List<ProjectStatus> getProjectStatus();
	
}
