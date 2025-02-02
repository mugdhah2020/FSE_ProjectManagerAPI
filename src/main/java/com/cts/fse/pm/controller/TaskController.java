package com.cts.fse.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fse.pm.entity.Parent;
import com.cts.fse.pm.entity.Task;
import com.cts.fse.pm.model.TaskModel;
import com.cts.fse.pm.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	@Autowired
	TaskService taskService;
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TaskModel> addTask(@RequestBody TaskModel taskModel) {
		
		return new ResponseEntity<TaskModel>(this.taskService.addTask(taskModel), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@PostMapping(value = "/addParent", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Parent> addParent(@RequestBody Task task) {
		return new ResponseEntity<Parent>(this.taskService.addParent(task), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(value = "/getAllParent",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  ResponseEntity<List<Parent>> getAllParent() {
		List<Parent> parentList = this.taskService.getAllParentTask();
		
		
		
		return new ResponseEntity<List<Parent>>(parentList, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(value = "/getAllTasks",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  ResponseEntity<List<TaskModel>> getAllTask() {
		List<TaskModel> taskList = this.taskService.getAllTask();
		
		return new ResponseEntity<List<TaskModel>>(taskList, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@PutMapping(value="/suspend/{taskId}",  produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
			public TaskModel endTask(@PathVariable("taskId") Long taskId){
			
			
			return taskService.endTask(taskId);
		
			
	}
	
	@CrossOrigin(origins = "http://localhost:4200") 
	@RequestMapping(value = "/update/{taskId}", method = RequestMethod.PUT, produces = "application/json", consumes = {
			"application/json" })
	public TaskModel editTask(@RequestBody TaskModel taskModel,@PathVariable("taskId") Long taskId){
		
		
		return taskService.editTask(taskModel,taskId);
		
		
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:4200") 
	@RequestMapping(value="/getTask/{taskId}", method=RequestMethod.GET)
	public ResponseEntity<TaskModel> getTask(@PathVariable("taskId") Long taskId) {
		TaskModel getTask = new TaskModel();
		
		getTask = taskService.getTaskById(taskId);
		return new ResponseEntity<TaskModel>(getTask, HttpStatus.OK);
		//return ResponseEntity.ok().header("Custom-Header", "getTaskById").body(getTask);

	}
	}

