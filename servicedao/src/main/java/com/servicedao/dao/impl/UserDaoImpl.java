package com.servicedao.dao.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.servicedao.annotations.AvailableForAspect;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class UserDaoImpl extends DAOimpl<User> {

	private Logger logger;
	Session session;
	private UserDaoImpl userDaoImpl;
	private CriteriaBuilder cb;

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
		List<User> users = (List<User>) getAll();
		User user = users.stream().filter(el -> el.getUserId() == id).findFirst().get();
		return user;
	}

	public User findByUserName(String userName) {
		session = openTransactionSession();
		User user = null;
		cb = session.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.where(cb.equal(root.get("userName"), userName));
		try {
			session = openTransactionSession();
			user = session.createQuery(query).getSingleResult();
			logger.info("User has been found by userName successfully!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("User was not foundby userName! Message: " + e.getMessage());
		} finally {
			closeTransactionSession();
		}
		return user;
	}

	@Override
	public Set<User> getAll() {
		return super.getAll();
	}

	@AvailableForAspect
	@Override
	public void insert(User user) {
		super.insert(user);
	}

	@Override
	public void update(User user) {
		super.update(user);
	}

	@Override
	public void delete(User user) {
		super.delete(user);
	}

	@Override
	public void deleteById(int id) {
		cb = session.getCriteriaBuilder();
		CriteriaDelete<User> delete = cb.createCriteriaDelete(User.class);
		Root<User> e = delete.from(User.class);
		delete.where(cb.equal(e.get("userId"), id));
		try {
			session = openTransactionSession();
			session.createQuery(delete).executeUpdate();
			logger.info("User has been deleted by id successfully!");
		} catch (IllegalStateException | HibernateException ex) {
			session.getTransaction().rollback();
			logger.warn("Task has not added to user! Message: " + ex.getMessage());
		} finally {
			closeTransactionSession();
		}
	}

	public void addTaskToUser(Task task, String userName) {
		session = openTransactionSession();
		try {
			User user = findByUserName(userName);
			user.addTaskToUser(task);
			session.update(user);
			logger.info("Task has been added to user successfully!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Task has not added to user! Message: " + e.getMessage());
		} finally {
			closeTransactionSession();
		}
	}

	public void addTasksToUser(Set<Task> tasks, String userName) {
		session = openTransactionSession();
		try {
			User user = findByUserName(userName);
			user.addTasksToUser(tasks);
			session.update(user);
			logger.info("Set<Task> has been added to user successfully!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Set<Task> has not added to user! Message: " + e.getMessage());
		} finally {
			closeTransactionSession();
		}
	}

	public void deleteTasksByUserName(String userName) {
		try {
			User user = findByUserName(userName);
			session = openTransactionSession();
			user.setTasks(null);
			session.saveOrUpdate(user);
			logger.info("Tasks has been deleted from user successfully!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Tasks has not deleted from user! Message: " + e.getMessage());
		} finally {
			closeTransactionSession();
		}
	}

	@AvailableForAspect
	public void addTaskToUserByUserName(Task task, String userName) {
		try {
			User user = findByUserName(userName);
			user.addTaskToUser(task);
			session = openTransactionSession();
			session.saveOrUpdate(user);
			logger.info("Task has been added to user successfully!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Task has not added to user! Message: " + e.getMessage());
		} finally {
			closeTransactionSession();
		}
	}

	@AvailableForAspect
	public void addTasksToUser(Set<Task> tasks, User user) {
		try {
			user.addTasksToUser(tasks);
			session = openTransactionSession();
			session.saveOrUpdate(user);
			logger.info("Tasks has been added to user successfully!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Tasks has not adde to user! Message: " + e.getMessage());
		} finally {
			closeTransactionSession();
		}
	}
	
	@AvailableForAspect
	public Set<Task> getUsersTaskByUserName(String userName) {
		Set<Task> tasks = null;
		try {
			User user = findByUserName(userName);
			tasks = user.getTasks();
			logger.info("Tasks has been found successfully by userName!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Tasks has not found! Message: " + e.getMessage());
		}
		return tasks;
	}
	
	@AvailableForAspect
	public Set<Task> getUsersTasksByUserId(int userId) {
		TaskDaoImpl taskDaoImpl = TaskDaoImpl.getInstance();
		Set<Task> allTasks = null;
		Set<Task> tasksByUserId = null;
		try {
			allTasks = taskDaoImpl.getAll();
			tasksByUserId = allTasks.stream().filter(t -> t.getUser().getUserId() == userId)
					.collect(Collectors.toSet());
			logger.info("Tasks has been found successfully by ID!");
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Tasks has not found! Message: " + e.getMessage());
		}
		return tasksByUserId;
	}

}
