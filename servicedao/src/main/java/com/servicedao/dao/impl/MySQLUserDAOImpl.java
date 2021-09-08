package com.servicedao.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.servicedao.dao.UserDAO;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.hibernate.SessionUtil;

/**
 * @inheritDoc
 */
public class MySQLUserDAOImpl extends SessionUtil implements UserDAO {

	static Logger log = Logger.getLogger(MySQLUserDAOImpl.class.getName());

	/**
	 * @inheritDoc
	 */
	@Override
	public void insert(User user) {
		Session session = openTransactionSession();
		try {
	        session.save(user);
	        log.info("User was inserted successfully!");
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("user not inserted! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
	}
	
	public void createUserAndAddHimTasks(User user, Set<Task> tasks) {
		Session session = openTransactionSession();
		try {
			user.setTasks(tasks);
	        session.save(user);
	        log.info("The user has been created and a tasks list has been added!");
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("User not created and a tasks list has been not added!" + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
	}

	/**
	 * @inheritDoc
	 */

	public User getById(int id) {
		Session session = openTransactionSession();
//		Query query = session.createQuery("from User u where u.id = :id");
//		query.setParameter("id", id);
//		User user = (User) query.getSingleResult();
		User user = session.get(User.class, id);
		closeTransactionSession();
		return user;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void update(User user) {
		Session session = openTransactionSession();
		String hql = "update User set firstName = :firstName, lastName = :lastName, userName = :userName, tasks = :tasks, where id = :id";
		Query query = null;
		try {
			query = session.createQuery(hql);
			query.setParameter("firstName", user.getFirstName());
			query.setParameter("lastName", user.getLastName());
			query.setParameter("userName", user.getUserName());
			query.setParameter("tasks", user.getTasks());
			query.setParameter("id", user.getUserId());
			query.executeUpdate();
		}
		catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
	        closeTransactionSession();
		}
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void deleteById(int id) {
		Session session = openTransactionSession();
		Query query = session.createQuery("delete from User u where u.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		closeTransactionSession();
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public List<User> getAll() {
		Session session = openTransactionSession();
		return session.createQuery("from User", User.class).list();
	}
}
