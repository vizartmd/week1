package com.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.BasicConfigurator;
import com.servicedao.command.taskcommand.TaskGetAllCommand;
import com.servicedao.command.taskcommand.TaskInsertCommand;
import com.servicedao.command.usercommand.UserGetAllCommand;
import com.servicedao.command.usercommand.UserInsertCommand;
import com.servicedao.datasource.DataSource;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.service.CommandInvoker;
import com.servicedao.service.mysqlservice.MySQLTaskService;
import com.servicedao.service.mysqlservice.MySQLUserService;

/**
 * @author vrobu1 class App with main method which is the entry point for the
 *         application
 */

public class App {
	public static void main(String[] args) throws SQLException {
		BasicConfigurator.configure();
		DataSource ds = DataSource.getInstance();
		CommandInvoker commandInvoker = new CommandInvoker();
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter userId");
//		int id = scanner.nextInt();
//		System.out.println("Enter first name");
//		String firstName = scanner.next();
//		System.out.println("Enter last name");
//		String lastName = scanner.next();
//		System.out.println("Enter userName"); 
//		String userName = scanner.next();
//		
		MySQLUserService mySQLUserService = new MySQLUserService();
//		UserInsertCommand userInsertCommand = new UserInsertCommand(mySQLUserService, firstName, lastName, userName);
//		commandInvoker.execute(userInsertCommand);
//		
//		UserUpdateCommand userUpdateCommand = new UserUpdateCommand(mySQLUserService, id, firstName, lastName, userName);
//		commandInvoker.execute(userUpdateCommand);
		
//		UserGetByIdCommand userGetByIdCommand = new UserGetByIdCommand(mySQLUserService, 3);
//		commandInvoker.execute(userGetByIdCommand);
//		System.out.println("User: " + userGetByIdCommand.getUser());
		
//		UserDeleteByIdCommand userDeleteByIdCommand = new UserDeleteByIdCommand(mySQLUserService, 1);
//		commandInvoker.execute(userDeleteByIdCommand);
		
		UserGetAllCommand userGetAllCommand = new UserGetAllCommand(mySQLUserService);
		commandInvoker.execute(userGetAllCommand);
		List<User> users = userGetAllCommand.getUsers();
		for (User u : users) {
			System.out.println(u.toString());
		}
		
//		System.out.println("Enter task id"); 
//		int taskId = scanner.nextInt();
//		System.out.println("Enter task title");
//		String title = scanner.next();
//		System.out.println("Enter task description");
//		String description = scanner.next();
//
//		MySQLTaskService mySQLTaskService = new MySQLTaskService();
//		
//		TaskDeleteByIdCommand taskDeleteByIdCommand = new TaskDeleteByIdCommand(mySQLTaskService, 10);
//		commandInvoker.execute(taskDeleteByIdCommand);
		
//		TaskUpdateCommand taskUpdateCommand = new TaskUpdateCommand(mySQLTaskService, 4, userId ,title, description);
//		commandInvoker.execute(taskUpdateCommand);		
		
//		TaskInsertCommand taskInsertCommand = new TaskInsertCommand(mySQLTaskService, title, description);
//		commandInvoker.execute(taskInsertCommand);
		
//		TaskUpdateCommand taskUpdateCommand = new TaskUpdateCommand(mySQLTaskService, 50, 30, "title 30 modified", "description 30 modified");
//		commandInvoker.execute(taskUpdateCommand);
		 
//		TaskGetByIdCommand taskGetByIdCommand = new TaskGetByIdCommand(mySQLTaskService, 6); 
//		commandInvoker.execute(taskGetByIdCommand);	 
//		System.out.println(taskGetByIdCommand.getTask());
		
//		TaskGetAllCommand taskGetAllCommand = new TaskGetAllCommand(mySQLTaskService);
//		commandInvoker.execute(taskGetAllCommand);
//		
//		List<Task> tasks = taskGetAllCommand.getTasks();
//		for (Task t : tasks) {
//			System.out.println(t.toString()); 
//		}

		scanner.close();
	}
}
