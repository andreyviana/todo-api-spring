package com.apirest.todo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.todo.model.TaskModel;
import com.apirest.todo.repository.TaskRepository;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

	@Autowired
	TaskRepository taskRepository;

	@PostMapping("/tasks")
	public TaskModel createTask(@RequestBody TaskModel t) {
		TaskModel newTask = this.taskRepository.save(t);

		return newTask;
	}

	@GetMapping("/tasks")
	public Iterable<TaskModel> getAllTasks() {
		return this.taskRepository.findAll();
	}

	@GetMapping("/tasks/{id}")
	public Optional<TaskModel> getTaskById(@PathVariable("id") Integer id) {
		Optional<TaskModel> task = this.taskRepository.findById(id);

		return task;
	}

	@PutMapping("/tasks/{id}")
	public TaskModel updateTask(@RequestBody TaskModel task, @PathVariable("id") Integer id) {
		Optional<TaskModel> taskToUpdateOptional = getTaskById(id);
		if(!taskToUpdateOptional.isPresent()) {
			return null;
		}
		TaskModel taskToUpdate = taskToUpdateOptional.get();

		if (task.getTask() != null) {
			taskToUpdate.setTask(task.getTask());
		}
		if (task.getIsComplete() != null) {
			taskToUpdate.setIsComplete(task.getIsComplete());
		}
		if (task.getTimeToCompleteInDays() != null) {
			taskToUpdate.setTimeToCompleteInDays(task.getTimeToCompleteInDays());
		}
		if (task.getTimeToCompleteInHours() != null) {
			taskToUpdate.setTimeToCompleteInHours(task.getTimeToCompleteInHours());
		}
		
		this.taskRepository.save(taskToUpdate);

		return taskToUpdate;
	}

	@DeleteMapping("/tasks/{id}")
	public TaskModel deleteTask(@PathVariable("id") Integer id) {
		Optional<TaskModel> TaskToDeleteOptional = getTaskById(id);
		if(!TaskToDeleteOptional.isPresent()) {
			return null;
		}
		TaskModel TaskToDelete = TaskToDeleteOptional.get();

		this.taskRepository.delete(TaskToDelete);
		return TaskToDelete;	
	}
}
