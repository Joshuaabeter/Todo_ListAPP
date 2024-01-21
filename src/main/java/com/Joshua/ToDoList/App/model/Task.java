package com.Joshua.ToDoList.App.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@Entity
@Table(name="TodoAPP")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long taskId;

    @NotNull
    @Size(min=5, max=50)
    @Column(name = "task_name")
    private String taskName;

    @NotEmpty
    @Column(name = "task_description")
    private String taskDescription;

    @NotNull
    @Column(name = "start_date")
    private LocalDate taskStartDate;// = LocalDateTime.now();
    @NotNull(message = "Task due date must not be null")
    @Future(message = "Task due date must be in the future")
    private LocalDate taskDueDate;

    private String taskCompleted;

    public Task(){

    }

    public Task(String taskName, String taskDescription, String startDate, String dueDate ){
        this.taskName=taskName;
        this.taskDescription=taskDescription;
        this.taskStartDate= LocalDate.parse(startDate, DateTimeFormatter.ofPattern("d-M-yyyy"));
        this.taskDueDate=LocalDate.parse(dueDate, DateTimeFormatter.ofPattern("d-M-yyyy"));

    }
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public LocalDate getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(LocalDate taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public LocalDate getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(LocalDate taskStartDate) {
        this.taskStartDate = taskStartDate;
    }
}
