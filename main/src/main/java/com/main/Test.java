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
/*
 * this class is intended only for short-term testing of the application,
 *  it will be removed soon
 */
public class Test {

	public static void main(String[] args) {

		BasicConfigurator.configure();

		UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
		TaskDaoImpl taskDaoImpl = TaskDaoImpl.getInstance();

		userDaoImpl.deleteById(21); // delete user by id
//		taskDaoImpl.deleteById(37); // delete task by id
//		
//		taskDaoImpl.deleteById(22);
//		System.out.println(taskDaoImpl.getAll());

//		User newUser = new User("Oleg", "Yancu", "olejka"); // create user and asign to him tasks and save user
//		Task task1 =  new Task("title 1 olejka", "Desc 1 olejka");
//		Task task2=  new Task("title 2 olejka", "Desc 2 olejka");
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

//		userDaoImpl.deleteTasksByUserName("olejka");

//		User user = userDaoImpl.findByUserName("olejka");
//		Task task2=  new Task("title 111111 olejka", "Desc 1111111 olejka");
//		Task task3=  new Task("title 222222 olejka", "Desc 2222222 olejka");
//		Task task4=  new Task("title 333333 olejka", "Desc 3333333 olejka");
//		Set<Task> tasks = new HashSet<>();
//		tasks.add(task2);
//		tasks.add(task3);
//		tasks.add(task4);
//		
//		user.addTasksToUser(tasks);
//

//		user2.setUserName("Oleg Yancu");
//		userDaoImpl.update(user2);
//		User user2 = userDaoImpl.findByUserName("007");
//		System.out.println("user: " + user2.getTasks());
//		user2.setTasks(null);
//		userDaoImpl.update(user2);
//		User user3 = userDaoImpl.findByUserName("007");
//		System.out.println("user: " + user3.getTasks());
//		System.out.println(user2.getUserName() + "'s tasks" + user2.getTasks().toString());

//		System.out.println("All users: " + users);
		
//		userDaoImpl.deleteTasksByUserName("007");
//		List<Task> tasks = taskDaoImpl.getAll();
//		System.out.println("All tasks: " + tasks);

//		Set<Task> tasks = userDaoImpl.getUsersTaskByUserName("papagal");
//		System.out.println(tasks);
		
		System.out.println("Done!");

	}

}
