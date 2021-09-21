package com.servicedao.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
	public User findById(int id) {
		Session session = openTransactionSession();
		List<User> users = null;
		User user = null;
		try {
			Criteria criteria = (Criteria) session.createCriteria(User.class);
			users = criteria.list();
			user = users.stream().filter(u -> u.getUserId() == id).findAny().get();
			logger.info("User by id: " + id + " has been found successfully " + user);
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

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<User> getAll() {
		Session session = openTransactionSession();
		List<User> users = null;
		try {
			Criteria criteria = (Criteria) session.createCriteria(User.class);
			users = criteria.list();
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
			Query query = session.createQuery("delete from User u where u.userId = :id");
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
			logger.info("in taskAddToUser() ");
			users = getAll();
			for (User myUser : users) {
				if (myUser.getUserName().equals(userName)) {
					logger.info("user first name : " + myUser.getFirstName());
					Set<Task> userTasks = myUser.getTasks();
					if (userTasks != null) {
						userTasks.add(task);
						System.out.println("userTasks: " + myUser.getTasks());
					} else {
						userTasks = new HashSet<Task>();
						userTasks.add(task);
						myUser.setTasks(userTasks);
						System.out.println("userTasks: " + myUser.getTasks());
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

	@Override
	public Set<Task> getUsersTask(String userName) {
		List<User> users = getAll();
		Set<Task> userTasks = null;
		User user = users.stream().filter(el -> el.getUserName() == userName).findFirst().get();
		return userTasks = user.getTasks();
	}
}
