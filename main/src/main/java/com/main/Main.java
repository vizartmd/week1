package com.main;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import com.main.multithreading.ThreadAssignTasksToUser;
import com.main.multithreading.ThreadCreateUser;
import com.main.multithreading.ThreadShowAllUsers;
import com.main.multithreading.ThreadShowUsersTasksByUserId;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.utils.CollectInfo;

public class Main {

	public static void main(String[] args) {

		BasicConfigurator.configure();
		Logger logger = Logger.getLogger(Main.class);
		logger.info("Starting");

		ExecutorService executorService = Executors.newFixedThreadPool(4);

		User user = CollectInfo.createUser();
		Set<Task> tasks = CollectInfo.createTask();

		ThreadCreateUser threadCreateUser = new ThreadCreateUser(user);
		try {
			executorService.submit(threadCreateUser).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		ThreadAssignTasksToUser threadAssignTasksToUser = new ThreadAssignTasksToUser(tasks, user.getUserName());
		try {
			executorService.submit(threadAssignTasksToUser).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		Set<User> myUsers = null;
		try {
			myUsers = (Set<User>) executorService.submit(new ThreadShowAllUsers().newCallable()).get();
			List<Integer> usersId = CollectInfo.getUsersIds(myUsers);
			System.out.println("All user's ID: " + usersId);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		Set<Task> myTasks = null;
		Integer userId = 0;
		try {
			userId = CollectInfo.selectUserIdFromExistingUsers();
			myTasks = (Set<Task>) executorService.submit(new ThreadShowUsersTasksByUserId(userId).newCallable()).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Tasks of user by ID: " + userId + " -> " + myTasks);

		executorService.shutdown();
		try {
			if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
				executorService.shutdown();
			}
		} catch (InterruptedException e) {
			executorService.shutdown();
		}

		System.out.println("Finished");
	}
}
