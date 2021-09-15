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
	
	static Logger log = Logger.getLogger(TaskDaoImpl.class.getName());

	@Override
	public Task getById(int id) {
		Session session = openTransactionSession();
		Task task = null;
		try {
			task = session.get(Task.class, id);
	        log.info("Task by id: " + id + " has been found successfully");
		}
		catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			log.warn("Task with id: " + id + " not found! " + e.getMessage());
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
			log.info("List of tasks has been recieved successfully!");
		}
		catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			log.warn("Task list not received!" + e.getMessage());
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
	        log.info("Task has been inserted successfully!");
		}
		catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			log.warn("Task not inserted! " + e.getMessage());
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
	        log.info("Task has been updated successfully!");
		}
		catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			log.warn("Task not updated! " + e.getMessage());
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
	        log.info("Task with id: " + id + " has been deleted successfully!");
		}
		catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			log.warn("Task with id: " + id + " not deleted! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
		
	}

}
