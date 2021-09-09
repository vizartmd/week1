package com.main;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;

import com.servicedao.command.usertaskcommand.CreateUserAndAddHimTasksCommand;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.email.MailSender;
import com.servicedao.service.CommandInvoker;
import com.servicedao.service.mysqlservice.MySQLUserService;

public class Main {

	public static void main(String[] args) {

        BasicConfigurator.configure();
        
//        Class cls = Class.forName("org.dennisit.reflect.entity.User");
//        String className = "org.dennisit.reflect.entity.User";
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("name", "dennisit");
//        map.put("age", 22);
//        map.put("email", "dennisit@163.com");
//
//        User user = (User)DynamicReflect.getInstance(className, map);
//        System.out.println(user.getName() + "," + user.getAge() + "," + user.getEmail());
		
        User user2 = new User();
        user2.setFirstName("Vasile"); 
        user2.setLastName("Gavrilita");
        user2.setUserName("gavrilash");
        
        Task task3 = new Task();
        task3.setTitle("Title1 for gavrilash");
        task3.setDescription("Description1 for gavrilash");
        
        Task task4 = new Task();
        task4.setTitle("Title2 for robuvictor");
        task4.setDescription("Description2 for gavrilash");
        
        Task task5 = new Task();
        task5.setTitle("Title3 for robuvictor");
        task5.setDescription("Description3 for gavrilash");
        
        Set tasks = new HashSet();
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        
        MySQLUserService mySQLUserService = new MySQLUserService();
        CommandInvoker commandInvoker = new CommandInvoker();
        CreateUserAndAddHimTasksCommand createUserAndAddHimTasksCommand = new CreateUserAndAddHimTasksCommand(mySQLUserService, user2, tasks);
        commandInvoker.execute(createUserAndAddHimTasksCommand);
        
        User user = createUserAndAddHimTasksCommand.getUser();
        
        MailSender mailSender = new MailSender();
        mailSender.sendEmail(user.toStringForEmail());
	}
}
