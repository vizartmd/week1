package com.servicedao.service;


import java.util.List;

import com.servicedao.domain.User;

public interface UserServiceIntf {
	
	void createUser(User user);

	public User findUserById(int id);

	public void updateUser(User user);

	public void deleteUser(int id);

	List<User> getAllUsers();
}
