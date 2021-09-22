package com.servicedao.dao;

import com.servicedao.domain.Task;
import com.servicedao.domain.User;

/**
 * UserDao interface
 * @author vrobu1
 * @version 1.0
 */
public interface UserDao extends DAO<User> {

	void addTaskToUser(Task task, String userName);

}
