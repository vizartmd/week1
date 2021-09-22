package com.main;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.BasicConfigurator;
import com.main.multithreading.ThreadAssignTaskToUser;
import com.main.multithreading.ThreadCreateUser;
import com.main.multithreading.ThreadShowAllUsers;
import com.main.multithreading.ThreadShowUsersTasks;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class Main {
	private static User user;
	private static Task task;

	public static void collectInfo() {
		System.out.println("Programm started...");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter information about the new user and the new task for him!");
		System.out.println("Enter first name");
		String firstName = scanner.nextLine();
		System.out.println("Enter last name");
		String lastName = scanner.nextLine();
		System.out.println("Enter username");
		String userName = scanner.nextLine();
	    Main.user = new User(firstName, lastName, userName);
		System.out.println("Enter task title");
		String title = scanner.nextLine();
		System.out.println("Enter task description");
		String description = scanner.nextLine();
		task = new Task(title, description);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException, ExecutionException   {
		BasicConfigurator.configure();
		Main.collectInfo();
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		ThreadCreateUser threadCreateUser = new ThreadCreateUser(user);
		executorService.submit(threadCreateUser).get();
		ThreadAssignTaskToUser threadAssignTaskToUser = new ThreadAssignTaskToUser(task, user.getUserName());
		executorService.submit(threadAssignTaskToUser).get();
		List<User> myUsers = (List<User>) executorService.submit(new ThreadShowAllUsers().newCallable()).get();
		List<Task> myTasks = (List<Task>) executorService.submit(new ThreadShowUsersTasks(user.getUserId()).newCallable()).get();
		System.out.println(myUsers);
		System.out.println(myTasks);
		
		executorService.shutdown();

		System.out.println("Finished");
	}
}

