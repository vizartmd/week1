package com.servicedao.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.servicedao.dao.TaskDao;
import com.servicedao.domain.Task;
import com.servicedao.hibernate.SessionUtil;

public class TaskDaoImpl  extends SessionUtil implements TaskDao {
	
	private Logger logger;
	private TaskDao taskDao;

	private TaskDaoImpl() {
	}

	private final static class SingletonHolder {
		private final static TaskDaoImpl INSTANCE = new TaskDaoImpl();
	}

	public static TaskDaoImpl getInstance() {
		TaskDaoImpl taskDaoImpl = SingletonHolder.INSTANCE;
		
		if (taskDaoImpl.logger == null) {
			taskDaoImpl.logger = Logger.getLogger(TaskDaoImpl.class);
		}
		if (taskDaoImpl.taskDao == null) {
			taskDaoImpl.taskDao = SingletonHolder.INSTANCE;
		}
		return taskDaoImpl;
	}

	@Override
	public Task getById(int id) {
		Session session = openTransactionSession();
		Task task = null;
		try {
			task = session.get(Task.class, id);
			logger.info("Task by id: " + id + " has been found successfully");
		}
		catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Task with id: " + id + " not found! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
		return task;
	}

	@Override
	public List<Task> getAll() {
		Session session = openTransactionSession();
		List<Task> tasks = null;
		try {
			tasks = session.createQuery("from Task", Task.class).list();
			logger.info("List of tasks has been recieved successfully!");
		}
		catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Task list not received!" + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
		return tasks;
	}

	@Override
	public void insert(Task task) {
		Session session = openTransactionSession();
		try {
	        session.save(task);
	        logger.info("Task has been inserted successfully!");
		}
		catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Task not inserted! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
		
	}

	@Override
	public void update(Task task) {
		Session session = openTransactionSession();
		try {
			String hql = "update Task set title = :title, description = :description where taskId = :taskId";
			Query query = session.createQuery(hql);
			query.setParameter("title", task.getTitle());
			query.setParameter("description", task.getDescription());
			query.setParameter("taskId", task.getTaskId());
			query.executeUpdate();
			logger.info("Task has been updated successfully!");
		}
		catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Task not updated! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
	}

	@Override
	public void deleteById(int id) {
		Session session = openTransactionSession();
		try {
			session = openTransactionSession();
			Query query = session.createQuery("delete from Task t where t.taskId = :taskId");
			query.setParameter("taskId", id);
			query.executeUpdate();
			logger.info("Task with id: " + id + " has been deleted successfully!");
		}
		catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Task with id: " + id + " not deleted! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
		
	}

}