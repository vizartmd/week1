package com.servicedao.daointf;

import java.util.List;
import com.servicedao.domain.User;

public interface UserDAOIntf extends DAOIntf<User> {

	/**
	 * @inheritDoc
	 */
	public void insert(User user);

	/**
	 * @inheritDoc
	 */
	public User getById(int id);

	/**
	 * @inheritDoc
	 */
	public void update(User user);

	/**
	 * @inheritDoc
	 */
	public void deleteById(int id);

	/**
	 * @inheritDoc
	 */
	public List<User> getAll();

}