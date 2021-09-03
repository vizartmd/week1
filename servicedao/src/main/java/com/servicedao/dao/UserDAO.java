package com.servicedao.dao;

import java.util.List;
import com.servicedao.domain.User;

public interface UserDAO extends DAO<User> {

	/**
	 * @inherited
	 */
	public void insert(User user);

	/**
	 * @inherited
	 */
	public User getById(int id);

	/**
	 * @inherited
	 */
	public void update(User user);

	/**
	 * @inherited
	 */
	public void deleteById(int id);

	/**
	 * @inherited
	 */
	public List<User> getAll();

}