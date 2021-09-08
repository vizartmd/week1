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
        user2.setFirstName("Yurii");
        user2.setLastName("Gagarin");
        user2.setUserName("gagarini");
        
        Task task3 = new Task();
        task3.setTitle("Title1 for gagarini");
        task3.setDescription("Description1 for gagarini");
        
        Task task4 = new Task();
        task4.setTitle("Title2 for gagarini");
        task4.setDescription("Description2 for gagarini");
        
        Task task5 = new Task();
        task5.setTitle("Title3 for gagarini");
        task5.setDescription("Description3 for gagarini");
        
        Set tasks = new HashSet();
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        
        MySQLUserService mySQLUserService = new MySQLUserService();
        CommandInvoker commandInvoker = new CommandInvoker();
        CreateUserAndAddHimTasksCommand createUserAndAddHimTasksCommand = new CreateUserAndAddHimTasksCommand(mySQLUserService, user2, tasks);
        commandInvoker.execute(createUserAndAddHimTasksCommand);
	}
}
