package com.cts.fse.pm.service;

import java.util.List;
import java.util.Set;

import com.cts.fse.pm.entity.Project;
import com.cts.fse.pm.entity.Task;

public interface ProjectService {
	List<Project> getAllProjects();
	Project addProject(Project project);
	void suspendProject(Long projectId);
	 Set<Task> getTaskListByProject(Long projectId); 
	 int getCompletedTask(Long projectId);
}
