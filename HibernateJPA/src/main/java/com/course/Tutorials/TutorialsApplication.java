package com.course.Tutorials;

import com.course.Tutorials.DAO.UserDAO;
import com.course.Tutorials.Entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TutorialsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDAO userDAO){
		return runner -> {
			createUser(userDAO);
			viewUsers(userDAO);
			//updateUser(userDAO);
			deleteUser(userDAO);
		};
	}

	public void createUser(UserDAO userDAO){
		User user = new User();
		user.setAge(10);
		user.setName("User1");
		userDAO.save(user);
	}

	public void viewUsers(UserDAO userDAO){
		List<User> usersList = userDAO.getAll();
		System.out.println(usersList);
	}

	public void updateUser(UserDAO userDAO){
		User user = userDAO.getById(1);
		user.setName("UserSON");
		userDAO.update(user);
	}

	public void deleteUser(UserDAO userDAO){
		userDAO.delete(1);
	}
}
