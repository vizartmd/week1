package com.main;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.log4j.BasicConfigurator;
import com.main.multithreading.ThreadAssignTaskToUser;
import com.main.multithreading.ThreadCreateUser;
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
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		ThreadCreateUser threadCreateUser = new ThreadCreateUser(main.user);
		Future createUser = executorService.submit(threadCreateUser);
		createUser.get();
		ThreadAssignTaskToUser threadAssignTaskToUser = new ThreadAssignTaskToUser(main.task, main.user.getUserName());
		Future createTask = executorService.submit(threadAssignTaskToUser);
		createTask.get();
//		List<Callable<Void>> list = new ArrayList<>();
//		list.add(new ThreadShowAllUsers().newCallable());
//		list.add(new ThreadShowAllTasks().newCallable());
//		executorService.invokeAll(list);
		executorService.shutdown();

//		List<User> userList = (List<User>) ((Future) new ThreadShowAllUsers().newCallable()).get();
//		List<Task>tasksList = (List<Task>) ((Future) new ThreadShowAllTasks().newCallable()).get();
//		System.out.println(userList);
//		System.out.println(tasksList);
		
		System.out.println("Finished");
	}
}

