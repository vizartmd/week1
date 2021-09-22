package com.servicedao.service;

import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public interface UserService extends Service<User> {

	void addTaskToUser(Task task, String userName);
	
}
