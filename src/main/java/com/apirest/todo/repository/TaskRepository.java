package com.apirest.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.apirest.todo.model.TaskModel;

@Repository
public interface TaskRepository extends CrudRepository<TaskModel, Integer>{

}
