package com.servicedao.service;

import java.util.Set;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public interface UserService extends Service<User> {

	void addTaskToUserByUserName(Task task, String userName);
	
	void addTasksToUserByUserName(Set<Task> tasks, User user);
	
	Set<Task> getUsersTasksByUserName(String userName);
	
}
