package com.servicedao.dao;

import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public interface UserDao extends DAO<User> {

	void AddTaskToUser(Task task, String userName);

}
