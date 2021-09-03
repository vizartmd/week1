package com.servicedao.service.mysqlservice;

import java.util.List;

import com.servicedao.dao.impl.MySQLTaskDAOImpl;
import com.servicedao.domain.Task;
import com.servicedao.service.ServiceIntf;

/**
 * This class represents the service layer that works with the Task class
 * and the MySQL DAO layer
 */
public class MySQLTaskService implements ServiceIntf<Task>{
	MySQLTaskDAOImpl mySQLTaskDAOImpl;
	
	public void insert(Task task) {
		mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
		mySQLTaskDAOImpl.insert(task);
	}
	
	public Task getById(int id) {
		mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
		return mySQLTaskDAOImpl.getById(id);
	}
	
	public void update(Task task) {
		mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
		mySQLTaskDAOImpl.update(task);
	}
	
	public void deleteById(int id) {
		mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
		mySQLTaskDAOImpl.deleteById(id);
	}
	
	public List<Task> getAll() {
		mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
		return mySQLTaskDAOImpl.getAll();
	}
}
