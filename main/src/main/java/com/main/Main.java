package com.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.apache.log4j.BasicConfigurator;
import com.servicedao.command.usertaskcommand.CreateUserAndAddHimTasksCommand;
import com.servicedao.dao.impl.MySQLTaskDAOImpl;
import com.servicedao.dao.impl.MySQLUserDAOImpl;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.email.MailSender;
import com.servicedao.reflection.DynamicReflect;
import com.servicedao.service.CommandInvoker;
import com.servicedao.service.mysqlservice.MySQLUserService;

public class Main {
	
	public static void main(String[] args) throws Exception {

        BasicConfigurator.configure();
        
        
        Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter User first name");
		String firstName_scann = scanner.nextLine();
		System.out.println("Enter User last name");
		String lastName_scann = scanner.nextLine();
		System.out.println("Enter userName");
		String userName_scann = scanner.nextLine();
        
        Class clazz = User.class;
		Object user = clazz.newInstance();
		
        Field first_name = user.getClass().getDeclaredField("firstName");
        first_name.setAccessible(true);
        first_name.set(user, firstName_scann);
        String firstName = (String) first_name.get(user);
        System.out.println("field: " + firstName);
        
        Field last_name = user.getClass().getDeclaredField("lastName");
        last_name.setAccessible(true);
        last_name.set(user, lastName_scann);
        String lastName = (String) last_name.get(user);
        System.out.println("field: " + lastName);
        
        Field user_name = user.getClass().getDeclaredField("userName");
        user_name.setAccessible(true);
        user_name.set(user, userName_scann);
        String userName = (String) user_name.get(user);
        System.out.println("field: " + userName);
        
        System.out.println("Enter title for task 1");
		String task1_title = scanner.nextLine();
		System.out.println("Enter description for task 1");
		String task1_description = scanner.nextLine();
		System.out.println("Enter title for task 2");
		String task2_title = scanner.nextLine();
		System.out.println("Enter description for task 2");
		String task2_description = scanner.nextLine();
        
        Class clazzT = Task.class;
		Object task1 = clazzT.newInstance();
		
		Field title1_ = task1.getClass().getDeclaredField("title");
        title1_.setAccessible(true);
        title1_.set(task1, task1_title);
        String title1 = (String) title1_.get(task1);
        System.out.println("field: " + title1);
        
        Field description1_ = task1.getClass().getDeclaredField("description");
        description1_.setAccessible(true);
        description1_.set(task1, task1_description);
        String description1 = (String) description1_.get(task1);
        System.out.println("field: " + description1);
        
        Object task2 = clazzT.newInstance();
        Field title2_ = task1.getClass().getDeclaredField("title");
        title2_.setAccessible(true);
        title2_.set(task2, "task2_title");
        String title2 = (String) title2_.get(task2);
        System.out.println("field: " + title2);
        
        Field description2_ = task2.getClass().getDeclaredField("description");
        description2_.setAccessible(true);
        description2_.set(task2, task2_description);
        String description2 = (String) description2_.get(task2);
        System.out.println("field: " + description2);
        
        
        Set<Task> tasks = new HashSet<Task>();
        tasks.add((Task) task1);
        tasks.add((Task) task2);
        
        Field userTasks = user.getClass().getDeclaredField("tasks");
        userTasks.setAccessible(true);
        userTasks.set(user, tasks);
        
        System.out.println(user);
        
        Method toStringForEmail = user.getClass().getDeclaredMethod("toStringForEmail");
        String email = (String) toStringForEmail.invoke(user);
        
        MailSender mailSender = new MailSender();
        mailSender.sendEmail(email);
        
        MySQLUserService mySQLUserService = new MySQLUserService();
        CommandInvoker commandInvoker = new CommandInvoker();
        CreateUserAndAddHimTasksCommand createUserAndAddHimTasksCommand = new CreateUserAndAddHimTasksCommand(mySQLUserService, (User) user, tasks);
        commandInvoker.execute(createUserAndAddHimTasksCommand);

	}
}
