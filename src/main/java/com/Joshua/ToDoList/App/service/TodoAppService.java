package com.Joshua.ToDoList.App.service;

import com.Joshua.ToDoList.App.model.Task;
import com.Joshua.ToDoList.App.repository.TodoAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoAppService {
    @Autowired
    private TodoAppRepository todoAppRepository;

    public List<Task> getAllTasks() {
        List<Task> allTasks = new ArrayList<>();

        todoAppRepository.findAll().forEach(allTasks::add);

        return allTasks;
    }

    public Optional<Task> getEachTask(Long id) {

        return todoAppRepository.findById(id);
    }

    public void addTask(Task task) {

        todoAppRepository.save(task);

    }

    public void updateTask(Long id, Task todoApp) {
        if (todoAppRepository.findById(id).get() != null) {
            todoAppRepository.save(todoApp);
        }
    }

    public void deleteTask(Long id) {

        todoAppRepository.deleteById(id);
    }
    public List<Task> searchTasks(String taskName) {
        return todoAppRepository.findByTaskNameContainingIgnoreCase(taskName);
    }
}
