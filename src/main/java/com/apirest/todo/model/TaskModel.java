package com.apirest.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class TaskModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "(task) field cannot be blank")
	private String task;

	@Column(name = "time_to_complete_in_days")
	private Integer timeToCompleteInDays;

	@Column(name = "time_to_complete_in_hours")
	private Integer timeToCompleteInHours;

	@NotNull(message = "(isComplete) field cannot be null")
	private Boolean isComplete;

	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}

	public String getTask() {return this.task;}
	public void setTask(String task) {this.task = task;}

	public Integer getTimeToCompleteInDays() {return this.timeToCompleteInDays;}
	public void setTimeToCompleteInDays(Integer days) {this.timeToCompleteInDays = days;}

	public Integer getTimeToCompleteInHours() {return this.timeToCompleteInHours;}
	public void setTimeToCompleteInHours(Integer hours) {this.timeToCompleteInHours = hours;}

	public Boolean getIsComplete() {return this.isComplete;}
	public void setIsComplete(Boolean isComplete) {this.isComplete = isComplete;}
}

