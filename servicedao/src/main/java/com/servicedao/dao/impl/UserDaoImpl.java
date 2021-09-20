package com.servicedao.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.servicedao.annotations.AvailableForAspect;
import com.servicedao.dao.DAO;
import com.servicedao.dao.TaskDao;
import com.servicedao.dao.UserDao;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.hibernate.SessionUtil;

public class UserDaoImpl extends SessionUtil implements UserDao {

	private Logger logger;
	private UserDao userDao;

	private UserDaoImpl() {
	}

	private final static class SingletonHolder {
		private final static UserDaoImpl INSTANCE = new UserDaoImpl();
	}

	public static UserDaoImpl getInstance() {
		UserDaoImpl userDaoImpl = SingletonHolder.INSTANCE;

		if (userDaoImpl.logger == null) {
			userDaoImpl.logger = Logger.getLogger(UserDaoImpl.class);
		}
		if (userDaoImpl.userDao == null) {
			userDaoImpl.userDao = SingletonHolder.INSTANCE;
		}
		return userDaoImpl;
	}

	@Override
	public User getById(int id) {
		Session session = openTransactionSession();
		User user = null;
		try {
			user = session.get(User.class, id);
			logger.info("User by id: " + id + " has been found successfully");
			return user;
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("User with id: " + id + " not found! Message: " + e.getMessage());
		} finally {
			closeTransactionSession();
		}
		closeTransactionSession();
		return user;
	}

	@Override
	public List<User> getAll() {
		Session session = openTransactionSession();
		List<User> users = null;
		try {
			users = (List<User>) session.createQuery("from User", User.class).list();
			logger.info("User list was recieved successfully!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("User list not received! Message: " + e.getMessage());
		} finally {
			closeTransactionSession();
		}
		return users;
	}

//	@AvailableForAspect
	@Override
	public void insert(User user) {
		Session session = openTransactionSession();
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
		Session session = openTransactionSession();
		try {
			session.update(user);
			logger.info("User has been updated successfully!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("User not updated! " + e.getMessage());
		} finally {
			closeTransactionSession();
		}
	}

	@Override
	public void deleteById(int id) {
		Session session = openTransactionSession();
		try {
			Query query = session.createQuery("delete from User u where u.id = :id");
			query.setParameter("id", id);
			query.executeUpdate();
			logger.info("User has been deleted successfully!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("User not deleted! Message: " + e.getMessage());
		} finally {
			closeTransactionSession();
		}
	}

	@Override
	public void AddTaskToUser(Task task, String userName) {
		Session session = openTransactionSession();
		List<User> users = null;
		Set<Task> tasks = null;
		User user = null;
		
		try {
			System.out.println("in taskAddToUser() ");
			users = getAll();
			for (User myUser : users) {
				if (myUser.getUserName().equals(userName)) {
					System.out.println("user first name : " + myUser.getFirstName());
					Set<Task>userTasks = myUser.getTasks();
					if (userTasks != null) {
						userTasks.add(task);
					} else {
						userTasks = new HashSet<Task>();
						userTasks.add(task);
						myUser.setTasks(userTasks);
					}
					update(myUser);
					logger.info("Task was added to user!");
				}
			}
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Task has no added to " + userName + "! " + e.getMessage());
		} finally {
			closeTransactionSession();
		}
	}

}
