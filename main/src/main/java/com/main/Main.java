package com.main;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.main.command.CommandInvoker;
import com.main.command.taskcommand.TaskGetByIdCommand;
import com.main.command.usercommand.UserGetByIdCommand;
import com.main.command.usercommand.UserInsertCommand;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException,
			SecurityException, NoSuchMethodException, InvocationTargetException {

		BasicConfigurator.configure();
		CommandInvoker commandInvoker = new CommandInvoker();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter User first name");
		String firstName_scann = scanner.nextLine();
		System.out.println("Enter User last name");
		String lastName_scann = scanner.nextLine();
		System.out.println("Enter userName");
		String userName_scann = scanner.nextLine();
		User user = new User();
		user.setFirstName(firstName_scann);
		user.setLastName(lastName_scann);
		user.setUserName(userName_scann);

		System.out.println("Enter title for task 1");
		String task1_title = scanner.nextLine();
		System.out.println("Enter description for task 1");
		String task1_description = scanner.nextLine();
		System.out.println("Enter title for task 2");
		String task2_title = scanner.nextLine();
		System.out.println("Enter description for task 2");
		String task2_description = scanner.nextLine();

		Task task1 = new Task();
		task1.setTitle(task1_title);
		task1.setDescription(task1_description);

		Task task2 = new Task();
		task2.setTitle(task2_title);
		task2.setDescription(task2_description);

		Set<Task> tasks = new HashSet<Task>();
		tasks.add((Task) task1);
		tasks.add((Task) task2);

		user.setTasks(tasks);
		UserInsertCommand insertCommand = new UserInsertCommand(user);
		commandInvoker.execute(insertCommand);

//		GetByIdCommand getByIdCommandUser = new GetByIdCommand(DatabaseTypes.MYSQL, 6, new User());
//		commandInvoker.execute(getByIdCommandUser);
//		User user1 = (User) getByIdCommandUser.getItem();
//		System.out.println(user1);
//
//		GetByIdCommand getByIdCommandTask = new GetByIdCommand(DatabaseTypes.MYSQL, 10, new Task());
//		commandInvoker.execute(getByIdCommandTask);
//		Task task = (Task) getByIdCommandTask.getItem();
//		System.out.println(task);
	}
}
