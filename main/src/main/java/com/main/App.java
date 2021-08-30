package com.main;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.BasicConfigurator;
import com.servicedao.daoimpl.MySQLTaskDAOImpl;
import com.servicedao.daointf.TaskDAOIntf;
import com.servicedao.datasource.DataSource;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.enums.DatabaseTypes;
import com.servicedao.service.CommandInvoker;
import com.servicedao.service.ServiceFactory;
import com.servicedao.service.mysqlservice.MySQLService;
import com.servicedao.service.mysqlservice.MySQLTaskService;
import com.servicedao.service.mysqlservice.MySQLUserService;

/**
 * @author vrobu1
 * logger log to target -> apidocs folder
 * class App with main method which is starting point for the application
 */

public class App {
	public static void main(String[] args) throws SQLException {

		BasicConfigurator.configure();
		DataSource ds = DataSource.getInstance();
		
		MySQLService mySQLService = (MySQLService) ServiceFactory.getServiceFactory(DatabaseTypes.MYSQL);
		MySQLTaskService mySQLTaskService = mySQLService.getMySQLTaskService();
		MySQLUserService mySQLUserService = mySQLService.getMySQLUserService();
		Scanner scanner = new Scanner(System.in);
		
//		System.out.println("Enter first name");
//		String firstName = scanner.nextLine();
//		System.out.println("Enter last name");
//		String lastName = scanner.nextLine();
//		System.out.println("Enter userName");
//		String userName = scanner.nextLine();
//		User user = new User(23, firstName, lastName, userName);
		
//		mySQLUserService.updateUser(23, firstName, lastName, userName);
//		User user1 = mySQLUserService.getUserById(25);
		
//		System.out.println(user1);
		
//		List<User> users = mySQLUserService.gelAllUsers();
//		for (User u : users) {
//			System.out.println(u.toString());
//		}
		
//		System.out.println("Enter task id");
//		int id = scanner.nextInt();
//		System.out.println("Enter task userId");
//		int userId = scanner.nextInt();
//		System.out.println("Enter task title");
//		String title = scanner.next();
//		System.out.println("Enter task description");
//		String description = scanner.next();
		
//		mySQLTaskService.updateTask(id, userId, title, description);
		mySQLTaskService.deleteTask(15);
		List<Task> tasks= mySQLTaskService.gelAllTasks();
		for (Task t : tasks) {
			System.out.println(t);
		}
		
		
//		CommandInvoker commandInvoker = new CommandInvoker();
//		TaskDAOIntf mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
//		TaskInsertCommand taskInsertCommand = new TaskInsertCommand(mySQLTaskDAOImpl, userId, title, description);
//		commandInvoker.execute(taskInsertCommand);
		
//		TaskGetAllCommand taskGetAllCommand = new TaskGetAllCommand(mySQLTaskDAOImpl);
//		commandInvoker.execute(taskGetAllCommand);
		
//		mySQLTaskService.updateTask(32, 23, "000000000", "333333333333333");
//		mySQLTaskService.deleteTask(25);
		
//		List<Task> tasks = mySQLTaskService.gelAllTasks();
//		for (Task t : tasks) {
//			System.out.println(t.toString());
//		}
		
//		System.out.println("Task with id: 34 = " + mySQLTaskService.getTaskById(34));

		scanner.close();
		Connection con = ds.getConnection();
		if (con != null)
			con.close();
	}
}