package com.main.multithreading;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class Programm {

	ExecutorService executorService;
	User user;
	Task task;
	
	public Programm() {
		this.executorService = Executors.newFixedThreadPool(1);
	}

	public void collectInfo() throws InterruptedException, ExecutionException {
		System.out.println("Programm started...");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter information about the new user and the new task for him!");
		System.out.println("Enter first name");
		String firstName = scanner.nextLine();
		System.out.println("Enter last name");
		String lastName = scanner.nextLine();
		System.out.println("Enter username");
		String userName = scanner.nextLine();
		this.user = new User(firstName, lastName, userName);
		System.out.println(user);
		System.out.println("Enter task title");
		String title = scanner.nextLine();
		System.out.println("Enter task description");
		String description = scanner.nextLine();
		this.task = new Task(title, description);
		System.out.println(task); 
		execute();
	}

	@SuppressWarnings("unchecked")
	private void execute() throws InterruptedException, ExecutionException {
		executorService.execute(new ThreadCreateUser(user));
		executorService.execute(new ThreadCreateTask(task));
		Future<User> future = executorService.submit(new ThreadShowAllUsers().newCallable());
		List<User> users = (List<User>) future.get();
		System.out.println(users);
		Future<User> future2 = executorService.submit(new ThreadShowAllTasks().newCallable());
		List<Task> tasks = (List<Task>) future2.get();
		System.out.println(tasks);
		executorService.shutdown();
	}
}


