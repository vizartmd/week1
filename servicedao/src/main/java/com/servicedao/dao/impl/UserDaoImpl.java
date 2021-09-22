package com.servicedao.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.servicedao.dao.UserDao;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class UserDaoImpl extends DAOimpl<User> {
	
	private Logger logger;
	Session session;
	private UserDaoImpl userDaoImpl;
	
	
	protected UserDaoImpl(Class<User> clazz) {
		super(clazz);
	}

	private final static class SingletonHolder {
		private final static UserDaoImpl INSTANCE = new UserDaoImpl(User.class);
	}

	public static UserDaoImpl getInstance() {
		UserDaoImpl userDaoImpl = SingletonHolder.INSTANCE;

		if (userDaoImpl.logger == null) {
			userDaoImpl.logger = Logger.getLogger(UserDaoImpl.class);
		}
		if (userDaoImpl.userDaoImpl == null) {
			userDaoImpl.userDaoImpl = new UserDaoImpl(User.class);
		}
		return userDaoImpl;
	}

	@Override
	public User findById(int id) {
		User user = super.findById(id);
		return user;
	}
	
	// ========== todo ============
	public void deleteTasksByUserName(String userName) { 
		session = openTransactionSession();
		List<User> users = super.getAll();
		User user = users.stream().filter(e -> e.getUserName().equals("serjik")).findFirst().get();
		System.out.println("user: " + user);
		System.out.println("user's tasks: " + user.getTasks());
		user.setTasks(null);
		System.out.println("user's tasks after null: " + user.getTasks());
		closeTransactionSession();
	}
	
	public User findByUserName(String userName) {
		session = openTransactionSession();
		User user = (User) session.createQuery("FROM User u WHERE u.userName =:userName ")
				.setParameter("userName", userName).list().get(0);
		closeTransactionSession();
		return user;
	}

	@Override
	public List<User> getAll() {
		return super.getAll();
	}

//	@AvailableForAspect
	@Override
	public void insert(User user) {
		session = openTransactionSession();
		try {
			session.save(user);
			logger.info("User has been inserted successfully!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("User not inserted! Message: " + e.getMessage());
		} finally {
			closeTransactionSession();
		}

	}

	@Override
	public void update(User user) {
		super.update(user);
	}

	@Override
	public void delete(User user) {
		super.delete(user);
	}

	// ========== to check ============
	@Override
	public void deleteById(int id) {
		super.deleteById(id);
	}

	// ========== to do ============
	public void addTaskToUser(Task task, String userName) {

		
	}

}
