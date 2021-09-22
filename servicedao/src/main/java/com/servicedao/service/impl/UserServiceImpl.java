package com.servicedao.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import com.servicedao.dao.UserDao;
import com.servicedao.dao.impl.DAOimpl;
import com.servicedao.dao.impl.UserDaoImpl;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.service.UserService;

public class UserServiceImpl implements UserService {

	private Logger logger;
	private static UserDaoImpl userDaoImpl;

	private UserServiceImpl() {
	}

	private final static class SingletonHolder {
		private final static UserServiceImpl INSTANCE = new UserServiceImpl();
	}

	public static UserServiceImpl getInstance() {
		UserServiceImpl userService = SingletonHolder.INSTANCE;

		if (userService.logger == null) {
			userService.logger = Logger.getLogger(UserService.class);
		}
		if (UserServiceImpl.userDaoImpl == null) {
			UserServiceImpl.userDaoImpl = UserDaoImpl.getInstance();
		}
		return userService;
	}

	@Override
	public User findById(int id) {
		logger.info("UserService.getById() method called");
		return (User) userDaoImpl.findById(id);
	}

	@Override
	public List<User> getAll() {
		logger.info("UserService.getAll() method called");
		return userDaoImpl.getAll();
	}

	@Override
	public void insert(User user) {
		logger.info("UserService.insert() method called");
		userDaoImpl.insert(user);
	}

	@Override
	public void update(User user) {
		logger.info("UserService.update() method called");
		userDaoImpl.update(user);
	}

	@Override
	public void deleteById(int id) {
		logger.info("UserService.deleteById() method called");
		userDaoImpl.deleteById(id);
	}

	public void addTaskToUser(Task task, String userName) {
		logger.info("UserService.AddTaskToUser() method called");
		userDaoImpl.addTaskToUser(task,userName);
	}

}
