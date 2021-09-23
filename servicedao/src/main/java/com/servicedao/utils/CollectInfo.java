package com.servicedao.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class CollectInfo {
	static Logger logger = Logger.getLogger(CollectInfo.class);
	static Scanner scanner = new Scanner(System.in);

	public static User createUser() {

		System.out.println("Enter information about the new user and the new task for him!");
		System.out.println("Enter first name");
		String firstName = scanner.nextLine() + "\n";
		System.out.println("Enter last name");
		String lastName = scanner.nextLine() + "\n";
		System.out.println("Enter userName");
		String userName = scanner.nextLine() + "\n";
		return new User(firstName, lastName, userName);

	}

	public static Set<Task> createTask() {
		Integer countOfTasks = 0;
		logger.info("How many tasks do you want to create?");
		Set<Task> tasks = new HashSet<>();
		int taskCounter = 1;

		countOfTasks = scanner.nextInt();
		scanner.nextLine();
		if (countOfTasks instanceof Integer) {
			for (int i = 0; i < countOfTasks; i++) {
				System.out.println("Create task number " + taskCounter);
				System.out.println("Enter title for task " + taskCounter);
				String firstTitle = scanner.nextLine() + "\n";
				System.out.println("Enter description for task " + taskCounter);
				String firstDescription = scanner.nextLine() + "\n";
				taskCounter++;
				Task task = new Task(firstTitle, firstDescription);
				tasks.add(task);

			}
			logger.info(taskCounter + " tasks has been created!");
			return tasks;
		} else {
			logger.info("Please enter a number!");
			createTask();
		}

		return tasks;
	}

	public static Integer selectUserIdFromExistingUsers() {
		logger.info("Enter user's id from the list above to see his tasks!");

		Integer id = scanner.nextInt();
		outer: if (id instanceof Integer) {
			return id;
		} else {
			logger.info("Please enter a valid id!");
			break outer;
		}
		return id;
	}
	public static List<Integer> getUsersIds(Set<User> myUsers) {
		List<Integer> usersId = new ArrayList<Integer>();

		for (User u : myUsers) {
			usersId.add(u.getUserId());
		}
		return usersId;
	}

}
