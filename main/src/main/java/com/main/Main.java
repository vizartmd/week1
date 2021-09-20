package com.main;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.log4j.BasicConfigurator;
import com.main.command.CommandInvoker;
import com.main.command.usercommand.UserGetAllCommand;
import com.main.multithreading.ThreadAssignTaskToUser;
import com.main.multithreading.ThreadCreateUser;
import com.main.multithreading.ThreadShowAllTasks;
import com.main.multithreading.ThreadShowAllUsers;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class Main {
	User user;
	Task task;

	public  void collectInfo() throws InterruptedException, ExecutionException {
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
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		BasicConfigurator.configure();
		Main main = new Main();
		main.collectInfo();
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		ThreadCreateUser threadCreateUser = new ThreadCreateUser(main.user);
		executorService.submit(threadCreateUser);
		ThreadAssignTaskToUser threadAssignTaskToUser = new ThreadAssignTaskToUser(main.task, main.user.getUserName());
		 executorService.submit(threadAssignTaskToUser);
		List<User> myUsers = (List<User>) executorService.submit(new ThreadShowAllUsers().newCallable()).get();
		List<Task> myTasks = (List<Task>) executorService.submit(new ThreadShowAllTasks().newCallable()).get();
		System.out.println(myUsers);
		System.out.println(myTasks);
		executorService.shutdown();
		System.out.println("Finished");
	}
}

