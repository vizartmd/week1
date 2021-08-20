package com.servicedao.service;
import java.util.List;

import com.servicedao.dao.UserDaoImpl;
import com.servicedao.dao.UserDaoIntf;
import com.servicedao.domain.User;

public class UserServiceImpl implements UserServiceIntf{
	UserDaoIntf userDao = new UserDaoImpl();

	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}

