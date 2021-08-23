package com.servicedao.daointf;

import java.util.List;

import com.servicedao.domain.User;

public interface UserDAO extends DAO<User> {

	public void insert(User user);

	public User getById(int id);

	public void update(User user, int id);

	public void deleteById(int id);

	public List<User> getAll();

}
