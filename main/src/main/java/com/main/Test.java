package com.main;

import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.hibernate.SessionUtil;

public class Test {

	public static void main(String[] args) {
		
		SessionUtil session = new SessionUtil();
		session.openTransactionSession();
		
//		User user = new User("Robu", "Victor", "robuvictor");
//		Task tasks1 =  new Task("title 1", "Desc 1");
//		Task tasks2=  new Task("title 2", "Desc 2");
//		
//		user.addTaskToUser(tasks1);
//		user.addTaskToUser(tasks2);
//		session.getSession().save(user);
		
		
		User user = session.getSession().get(User.class, 5);
		System.out.println("user: " + user);
		System.out.println("user's tasks: " + user.getTasks());		
		
		session.closeTransactionSession();
		System.out.println("Done!");
		
	}

}
