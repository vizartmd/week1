package com.main;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.main.multithreading.ThreadAssignTasksToUser;
import com.main.multithreading.ThreadCreateUser;
import com.main.multithreading.ThreadShowAllUsers;
import com.main.multithreading.ThreadShowUsersTasksByUserId;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.utils.CollectInfo;

public class Main {

	public static void main(String[] args) {

		BasicConfigurator.configure();
		Logger logger = Logger.getLogger(Main.class);

		logger.info("Starting");
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		User user = CollectInfo.createUser();
		Set<Task> tasks = CollectInfo.createTask();
		try {
			ThreadCreateUser threadCreateUser = new ThreadCreateUser(user);
			executorService.submit(threadCreateUser).get();

			ThreadAssignTasksToUser threadAssignTasksToUser = new ThreadAssignTasksToUser(tasks, user);
			executorService.submit(threadAssignTasksToUser).get();

			Set<User> myUsers = null;
			myUsers = (Set<User>) executorService.submit(new ThreadShowAllUsers().newCallable()).get();
			List<Integer> usersId = CollectInfo.getUsersIds(myUsers);
			System.out.println("All user's ID: " + usersId);

			Set<Task> myTasks = null;
			Integer userId = 0;
			userId = CollectInfo.selectUserIdFromExistingUsers();
			myTasks = (Set<Task>) executorService.submit(new ThreadShowUsersTasksByUserId(userId).newCallable()).get();
			System.out.println("Tasks of user by ID: " + userId + " -> " + myTasks);
			executorService.shutdown();
			if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
				executorService.shutdown();
			}
		} catch (IllegalStateException | HibernateException | InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("Finished");

	}
}
