package com.servicedao.daointf;

import java.util.List;

import com.servicedao.domain.User;

/**
 * interface with declaring methods for operating with the User object in the database
 */
public interface UserDAO extends DAO<User> {

	/**
	 * the method for inserting a user into the database
	 */
	public void insert(User user);

	/**
	 * method for getting a user from the database by id
	 */
	public User getById(int id);

	/**
	 * method for update the user in the database
	 */
	public void update(User user, int id);

	
	/**
	 * method for deleting a user from the database by id
	 */
	public void deleteById(int id);

	/**
	 * method for getting all the users in the database
	 */
	public List<User> getAll();

}
