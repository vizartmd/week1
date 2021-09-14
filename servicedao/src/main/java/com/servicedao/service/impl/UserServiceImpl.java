package com.servicedao.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import com.servicedao.dao.UserDao;
import com.servicedao.dao.impl.UserDaoImpl;
import com.servicedao.domain.User;
import com.servicedao.service.TaskService;

public class UserServiceImpl implements UserDao {

	private Logger logger;
	private UserDao userDao;

	private UserServiceImpl() {
	}

	private final static class SingletonHolder {
		private final static UserServiceImpl INSTANCE = new UserServiceImpl();
	}

	public static UserServiceImpl getInstance() {
		UserServiceImpl userService = SingletonHolder.INSTANCE;

		if (userService.logger == null) {
			userService.logger = Logger.getLogger(TaskService.class);
		}
		if (userService.userDao == null) {
			userService.userDao = new UserDaoImpl();
		}
		return userService;
	}

	@Override
	public User getById(int id) {
		logger.info("UserService.getById() method called");
		return userDao.getById(id);
	}

	@Override
	public List<User> getAll() {
		logger.info("UserService.getAll() method called");
		return userDao.getAll();
	}

	@Override
	public void insert(User user) {
		logger.info("UserService.insert() method called");
		userDao.insert(user);
	}

	@Override
	public void update(User user) {
		logger.info("UserService.update() method called");
		userDao.update(user);
	}

	@Override
	public void deleteById(int id) {
		logger.info("UserService.deleteById() method called");
	}

}
