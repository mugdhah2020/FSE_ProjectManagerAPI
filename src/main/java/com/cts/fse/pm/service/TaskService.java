package com.cts.fse.pm.service;

import java.util.List;

import com.cts.fse.pm.entity.Parent;
import com.cts.fse.pm.entity.Task;
import com.cts.fse.pm.model.TaskModel;

public interface TaskService {
	List<TaskModel> getAllTask();

	List<Parent> getAllParentTask();

	TaskModel addTask(TaskModel task);

	Parent addParent(Task parentTask);

	TaskModel getTaskById(Long taskId);

	TaskModel editTask(TaskModel taskModel, Long taskId);

	TaskModel endTask(Long taskId);

}
