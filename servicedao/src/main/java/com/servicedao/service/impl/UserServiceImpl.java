package com.servicedao.service.impl;

import java.util.Set;
import org.apache.log4j.Logger;
import com.servicedao.dao.DAOFactory;
import com.servicedao.dao.DAOFactory.DaoType;
import com.servicedao.dao.impl.UserDaoImpl;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.service.UserService;

public class UserServiceImpl implements UserService {

	private Logger logger;
	private UserDaoImpl userDaoImpl;
	private static DAOFactory dAOFactory;
	
	private final static class SingletonHolder {
		private final static UserServiceImpl INSTANCE = new UserServiceImpl();
	}

	public static UserServiceImpl getInstance() {
		UserServiceImpl userService = SingletonHolder.INSTANCE;
		dAOFactory = DAOFactory.getInstance();
		
		if (userService.logger == null) {
			userService.logger = Logger.getLogger(UserService.class);
		}
		if (userService.userDaoImpl == null) {
			userService.userDaoImpl = (UserDaoImpl) dAOFactory.getDao(DaoType.USERDAO);
		}
		return userService;
	}

	@Override
	public User findById(int id) {
		logger.info("UserServiceImpl.getById() method called");
		return (User) userDaoImpl.findById(id);
	}

	@Override
	public Set<User> getAll() {
		logger.info("UserServiceImpl.getAll() method called");
		return userDaoImpl.getAll();
	}

	@Override
	public void insert(User user) {
		logger.info("UserServiceImpl.insert() method called, user: " + user);
		userDaoImpl.insert(user);
	}

	@Override
	public void update(User user) {
		logger.info("UserServiceImpl.update() method called");
		userDaoImpl.update(user);
	}

	@Override
	public void deleteById(int id) {
		logger.info("UserServiceImpl.deleteById() method called");
		userDaoImpl.deleteById(id);
	}

	public void addTaskToUser(Task task, String userName) {
		logger.info("UserServiceImpl.addTaskToUser() method called");
		userDaoImpl.addTaskToUser(task,userName);
	}

	public void addTaskToUserByUserName(Task task, String userName) {
		logger.info("UserServiceImpl.addTaskToUserByUserName() method called");
		userDaoImpl.addTaskToUserByUserName(task,userName);
	}

	public Set<Task> getUsersTasksByUserName(String userName) {
		logger.info("UserService.getUsersTasksByUserName() method called");
		return userDaoImpl.getUsersTaskByUserName(userName);
	}

	public Set<Task> getUsersTasksByUserId(int userId) {
		logger.info("UserService.getUsersTasksByUserId() method called");
		return userDaoImpl.getUsersTasksByUserId(userId);
	}

	@Override
	public void addTasksToUserByUserName(Set<Task> tasks, User user) {
		logger.info("UserServiceImpl.addTasksToUserByUserName() method called");
		userDaoImpl.addTasksToUser(tasks,user);
	}

}
