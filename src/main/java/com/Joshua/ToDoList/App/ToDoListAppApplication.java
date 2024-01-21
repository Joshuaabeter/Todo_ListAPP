package com.Joshua.ToDoList.App;

import com.Joshua.ToDoList.App.model.Task;
import com.Joshua.ToDoList.App.repository.TodoAppRepository;
import com.Joshua.ToDoList.App.service.TodoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoListAppApplication implements CommandLineRunner {

	@Autowired
	private TodoAppRepository todoAppRepository;

	public static void main(String[] args) {
		SpringApplication.run(ToDoListAppApplication.class, args);
	}

	public void run (String... args) throws Exception{
//Hardcored class for testing -this can be deleted
		todoAppRepository.save(new Task("Validation","Spend at least 4 hours in the next 4 weeks studying javax JPA Validation",
				"16-1-2024", "22-2-2024"));
		todoAppRepository.save(new Task("Review Spring Security","Complete J.Wilson notes on spring security",
				"16-1-2024", "22-3-2024"));
		todoAppRepository.save(new Task("JUnit","Practise JUnit and Mockito test next week",
				"30-1-2024", "22-5-2024"));

	}
}
