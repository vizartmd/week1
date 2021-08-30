package com.servicedao.daointf;

import java.util.List;
import com.servicedao.domain.User;

public interface UserDAOIntf extends DAOIntf<User> {

	public void insert(User user);

	public User getById(int id);

	public void update(User user);

	public void deleteById(int id);

	public List<User> getAll();

}