package com.Joshua.ToDoList.App.repository;

import com.Joshua.ToDoList.App.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoAppRepository extends CrudRepository<Task, Long> {
    List<Task> findByTaskNameContainingIgnoreCase(String taskName);
}
