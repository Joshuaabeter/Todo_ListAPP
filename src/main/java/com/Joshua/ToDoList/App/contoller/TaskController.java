package com.Joshua.ToDoList.App.contoller;

import com.Joshua.ToDoList.App.model.Task;
import com.Joshua.ToDoList.App.service.TodoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    private TodoAppService todoAppService;


    @GetMapping("/")
    public  String getAllTasks(Model model){
        List <Task> taskList=todoAppService.getAllTasks();

        model.addAttribute("taskList", taskList);

        return  "list_tasks";
    }
    @GetMapping("/new_task")
    public String addTask(Model model){
        Task task=new Task();
        model.addAttribute("task", task);
        return "new_task";
    }
    @PostMapping(value = "/save_new-task")
    public String saveNewProduct( @Valid @ModelAttribute("task") Task task,
                                  BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "new_task";
        }

        todoAppService.addTask(task);
        return "redirect:/";
    }

    @GetMapping("/update_task/{tid}")
    public String updateTask (@PathVariable(name="tid")Long id,Model model) {
        model.addAttribute("task", todoAppService.getEachTask(id));

        return "update_task";
    }

    @PostMapping(value="/save_updated-task")
    public String saveUpdatedTask(@Valid @ModelAttribute("task") Task task,
                                  BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            return "update_task";
        }
        todoAppService.updateTask(task.getTaskId(), task);

        return "redirect:/";
    }
    @GetMapping("/delete_task/{tid}")
    public String deleteTask(@PathVariable(name="tid") Long id , Model model) {
        model.addAttribute("task", todoAppService.getEachTask(id));

        return "delete_task";
    }

    @PostMapping("/save_deleted-task")
    public String saveDeleteTask (@ModelAttribute("task") Task task) {
        todoAppService.deleteTask(task.getTaskId());

        return "redirect:/";
    }
    @GetMapping("/search_tasks")
    public String searchTasks(@RequestParam(name = "taskName") String taskName, Model model) {

    List<Task> searchTask=todoAppService.searchTasks(taskName);

    model.addAttribute("searchTask", searchTask);

    return "search_tasks";
    }

}
