package com.main;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;

import com.servicedao.datasource.DataSource;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.service.TaskServiceInvoker;
import com.servicedao.service.UserServiceInvoker;

/**
 * @author vrobu1
 * logger log to target -> apidocs folder
 * class App with main method which is starting point for the application
 */

public class App {
	public static void main(String[] args) throws SQLException {

		BasicConfigurator.configure();
		DataSource ds = DataSource.getInstance();
		
		UserServiceInvoker userServiceInvoker = new UserServiceInvoker();
		TaskServiceInvoker taskServiceInvoker = new TaskServiceInvoker();
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		
		System.out.println("Enter first name");
		String firstName = scanner.nextLine();
		System.out.println("Enter last name");
		String lastName = scanner.nextLine();
		System.out.println("Enter userName");
		String userName = scanner.nextLine();
		userServiceInvoker.insert(new User(firstName, lastName, userName));
		for (User u : userServiceInvoker.getAll()) {
			System.out.println(u.toString());
		}
		
		System.out.println("Enter title");
		String title = scanner.nextLine();
		System.out.println("Enter description");
		String description = scanner.nextLine();
		taskServiceInvoker.insert(new Task(13, title, description));
		for (Task t : taskServiceInvoker.getAll()) {
			System.out.println(t.toString());
		}
		
		Connection con = ds.getConnection();
		if (con != null)
			con.close();
	}
}