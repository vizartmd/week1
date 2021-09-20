package com.servicedao.service;

import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public interface UserService extends Service<User> {

	void AddTaskToUser(Task task, String userName);
	
}
