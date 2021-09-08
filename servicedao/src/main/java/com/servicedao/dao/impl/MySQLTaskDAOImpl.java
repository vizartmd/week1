package com.servicedao.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import com.servicedao.dao.TaskDAO;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.hibernate.SessionUtil;

/**
 * @inheritDoc
 */
public class MySQLTaskDAOImpl extends SessionUtil implements TaskDAO {

	static Logger log = Logger.getLogger(MySQLTaskDAOImpl.class.getName());

	@Override
	public void insert(Task task) {
		Session session = openTransactionSession();
		try {
	        session.save(task);
	        log.info("Task has been inserted successfully!");
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("Task not inserted! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
	}

	@Override
	public Task getById(int id) {
		Session session = openTransactionSession();
		Task task = null;
		try {
//			Query query = session.createQuery("from Task t where t.id = :id");
//			query.setParameter("id", id);
//			task = (Task) query.getSingleResult();
			task = session.get(Task.class, id);
	        log.info("Task by id: " + id + " has been found successfully");
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("Task with id: " + id + " not found! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
		return task;
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
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("Task not updated! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
	}

	@Override
	public void deleteById(int taskId) {
		Session session = openTransactionSession();
		try {
			session = openTransactionSession();
			Query query = session.createQuery("delete from Task t where t.taskId = :taskId");
			query.setParameter("taskId", taskId);
			query.executeUpdate();
	        log.info("Task with id: " + taskId + " has been deleted successfully!");
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("Task with id: " + taskId + " not deleted! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
	}

	@Override
	public List<Task> getAll() {
		Session session = openTransactionSession();
		List<Task> tasks = null;
		try {
			tasks = session.createQuery("from Task", Task.class).list();
			log.info("List of tasks has been recieved successfully!");
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("Task list not received!" + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
		return tasks;
	}
}
