package com.servicedao.service.mysqlservice;

import java.util.List;
import com.servicedao.dao.impl.MySQLUserDAOImpl;
import com.servicedao.domain.User;
import com.servicedao.service.ServiceIntf;

/**
 * This class represents the service layer that works with the User class
 * and the MySQL DAO layer
 */
public class MySQLUserService implements ServiceIntf<User> {
	MySQLUserDAOImpl mySQLUserDAOImpl;

	@Override
	public void insert(User user) {
		mySQLUserDAOImpl = new MySQLUserDAOImpl();
		mySQLUserDAOImpl.insert(user);
	}

	@Override
	public User getById(int id) {
		mySQLUserDAOImpl = new MySQLUserDAOImpl();
		return mySQLUserDAOImpl.getById(id);
	}

	@Override
	public void update(User user) {
		mySQLUserDAOImpl = new MySQLUserDAOImpl();
		mySQLUserDAOImpl.update(user);
	}

	@Override
	public void deleteById(int id) {
		mySQLUserDAOImpl = new MySQLUserDAOImpl();
		mySQLUserDAOImpl.deleteById(id);
	}

	@Override
	public List<User> getAll() {
		mySQLUserDAOImpl = new MySQLUserDAOImpl();
		return mySQLUserDAOImpl.getAll();
	}
}
