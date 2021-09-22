package com.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.servicedao.dao.impl.TaskDaoImpl;
import com.servicedao.dao.impl.UserDaoImpl;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class Test {

	public static void main(String[] args) {

		BasicConfigurator.configure();
		
		UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
		TaskDaoImpl taskDaoImpl = TaskDaoImpl.getInstance();
		
//		userDaoImpl.deleteById(18); // delete user by id
		taskDaoImpl.deleteById(35); // delete task by id
//		
//		taskDaoImpl.deleteById(22);
//		System.out.println(taskDaoImpl.getAll());
		
//		User newUser = new User("James", "Bond", "007"); // create user and asign to him tasks and save user
//		Task task1 =  new Task("title 1 007", "Desc 1 007");
//		Task task2=  new Task("title 2 007", "Desc 2 007");
//		Set<Task> tasks = new HashSet<>();
//		tasks.add(task1);
//		tasks.add(task2);
//		newUser.addTasksToUser(tasks);
//		userDaoImpl.insert(newUser);
		
//		User user = userDaoImpl.findById(16);
//		System.out.println("user with id 16: " + user);
//		userDaoImpl.insert(user);
		
//		Task task =taskDaoImpl.findById(30);
//		System.out.println(task);
		
		
//		((User) user.getTasks()).setTasks(null);
//		userDaoImpl.update(user);
//		User user = userDaoImpl.findByUserName("valiuha");
//		userDaoImpl.delete(user);
		
//		User user = userDaoImpl.findById(17);
//		user.setFirstName(newUser.getFirstName());
//		user.setLastName(newUser.getLastName());
//		user.setUserName(newUser.getUserName());
//		
//		userDaoImpl.update(user);
//		System.out.println("user: " + user);
		
//		Task task = taskDaoImpl.findById(32);
//		task.setTitle("new Title!!!");
//		taskDaoImpl.update(task);
		
//		Task task2 = taskDaoImpl.findById(29);
//		
//		System.out.println("userId of task 29: " + task2.getUser().getUserId());
//		taskDaoImpl.delete(task);
//		System.out.println("user: " + user);
//		Set<Task> tasks = userDaoImpl.findTasksByUserName("alexei");
//		System.out.println("user's tasks: " + user.getTasks().toString());
		
//		userDaoImpl.deleteTasksByUserName("serjik");
		
//		System.out.println("All users: " + users);
//
//		List<Task> tasks = taskDaoImpl.getAll();
//		System.out.println("All tasks: " + tasks);

		System.out.println("Done!");

	}

}
