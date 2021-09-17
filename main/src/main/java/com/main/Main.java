package com.main;

import java.util.Scanner;
import org.apache.log4j.BasicConfigurator;
import com.main.command.CommandInvoker;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		BasicConfigurator.configure();
		System.out.println("Main thread started...");
		
		CommandInvoker commandInvoker = new CommandInvoker();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter User first name\n");
		String firstName_scann = scanner.nextLine();
		System.out.println("Enter User last name\n");
		String lastName_scann = scanner.nextLine();
		System.out.println("Enter userName\n");
		String userName_scann = scanner.nextLine();
		User user = new User();
		user.setFirstName(firstName_scann);
		user.setLastName(lastName_scann);
		user.setUserName(userName_scann);

		System.out.println("Enter title for task 1\n");
		String task_title = scanner.nextLine();
		System.out.println("Enter description for task 1\n");
		String task_description = scanner.nextLine();

		Task task = new Task();
		task.setTitle(task_title);
		task.setDescription(task_description);

		
		CreateUser createUser = new CreateUser("Thread CreateUser", user);
		createUser.start();
		try {
			createUser.join();
		} catch (InterruptedException e) {

			System.out.printf("%s has been interrupted", createUser.getName());
		}
		
		AsignTaskToUser asignTaskToUser = new AsignTaskToUser("Thread  AsignTaskToUser", user, task);
		asignTaskToUser.start();
		try {
			asignTaskToUser.join();
		} catch (InterruptedException e) {

			System.out.printf("%s has been interrupted", asignTaskToUser.getName());
		}
		
		ShowAllUsers showAllUsers = new ShowAllUsers("Thread  ShowAllUsers");
		showAllUsers.start();
		try {
			showAllUsers.join();
		} catch (InterruptedException e) {

			System.out.printf("%s has been interrupted", showAllUsers.getName());
		}
		
		ShowAllUsersTasks showAllUsersTasks = new ShowAllUsersTasks("Thread  ShowAllUsersTasks", user);
		showAllUsersTasks.start();
		try {
			showAllUsersTasks.join();
		} catch (InterruptedException e) {

			System.out.printf("%s has been interrupted", showAllUsersTasks.getName());
		}
		System.out.println("Main thread finished...");

	}
}

class CreateUser extends Thread {
	User user;

	CreateUser(String name, User user) {
		super(name);
		this.user = user;
	}

	public void run() {

		System.out.printf("%s started... \n", Thread.currentThread().getName());
		try {
			System.out.println("Create the user: " + user);
			System.out.println("Here will be inserted the UserInsertCommand");
//			UserInsertCommand userInsertCommand = new UserInsertCommand(user);
//			CommandInvoker commandInvoker = new CommandInvoker();
//			commandInvoker.execute(userInsertCommand);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interrupted");
		}
		System.out.printf("%s finished... \n", Thread.currentThread().getName());
	}
}

class AsignTaskToUser extends Thread {
	User user;
	Task task;
	
	AsignTaskToUser(String name, User user, Task task) {
		super(name);
		this.user = user;
		this.task = task;
	}

	public void run() {

		System.out.printf("%s started... \n", Thread.currentThread().getName());
		try {
			System.out.println("Asign the task " + task + " to the user...");
			System.out.println("Here will be inserted the UserAddTaskCommand");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interrupted");
		}
		System.out.printf("%s finished... \n", Thread.currentThread().getName());
	}
}

class ShowAllUsers extends Thread {
	
	ShowAllUsers(String name) {
		super(name);
	}

	public void run() {

		System.out.printf("%s started... \n", Thread.currentThread().getName());
		try {
			System.out.println("Show all users...");
			System.out.println("Here will be inserted the UserGetAllCommand");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interrupted");
		}
		System.out.printf("%s finished... \n", Thread.currentThread().getName());
	}
}

class ShowAllUsersTasks extends Thread {
	User user;
	
	ShowAllUsersTasks(String name, User user) {
		super(name);
	}

	public void run() {

		System.out.printf("%s started... \n", Thread.currentThread().getName());
		try {
			System.out.println("Show all user's tasks...");
			System.out.println("Here will be inserted the UserGetAllTasksCommand");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interrupted");
		}
		System.out.printf("%s finished... \n", Thread.currentThread().getName());
	}
}
