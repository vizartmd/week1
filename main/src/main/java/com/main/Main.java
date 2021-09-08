package com.main;

import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.BasicConfigurator;
import com.servicedao.command.usertaskcommand.CreateUserAndAddHimTasksCommand;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.service.CommandInvoker;
import com.servicedao.service.mysqlservice.MySQLUserService;
public class Main {
	
	public static void main(String[] args) {

		BasicConfigurator.configure();
		
        User user2 = new User();
        user2.setFirstName("SomeFirstName");
        user2.setLastName("SomeLastName");
        user2.setUserName("SomeUserName");
        
        Task task3 = new Task();
        task3.setTitle("Title1 for SomeUserName");
        task3.setDescription("Description1 for SomeUserName");
        
        Task task4 = new Task();
        task4.setTitle("Title2 for SomeUserName");
        task4.setDescription("Description2 for SomeUserName");
        
        Set tasks = new HashSet();
        tasks.add(task3);
        tasks.add(task4);
        
        MySQLUserService mySQLUserService = new MySQLUserService();
        CreateUserAndAddHimTasksCommand createUserAndAddHimTasksCommand = new CreateUserAndAddHimTasksCommand(mySQLUserService, user2, tasks);
        CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.execute(createUserAndAddHimTasksCommand);
    }
	
}
