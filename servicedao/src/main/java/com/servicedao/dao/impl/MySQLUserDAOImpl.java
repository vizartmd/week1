package com.servicedao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import com.servicedao.dao.UserDAO;
import com.servicedao.datasource.DataSource;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.hibernate.SessionUtil;

/**
 * @inheritDoc
 */
public class MySQLUserDAOImpl extends SessionUtil implements UserDAO {
	
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;

	static Logger log = Logger.getLogger(MySQLUserDAOImpl.class.getName());

	/**
	 * @inheritDoc
	 */
	@Override
	public void insert(User user) {
		Session session = openTransactionSession();
		try {
	        session.save(user);
	        log.info("User has been inserted successfully!");
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("User not inserted! " + e.getMessage());
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
			log.warn("User not created and a tasks list not added!" + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
	}

	/**
	 * @inheritDoc
	 */

	public User getById(int userId) {
		Session session = openTransactionSession();
		User user = null;
		try {
//			Query query = session.createQuery("from User u where u.userId = :userId");
//			query.setParameter("userId", userId);
//			user = (User) query.getSingleResult();
			user = session.get(User.class, userId);
	        log.info("User by id: " + userId + " has been found successfully");
	        return user;
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("User with id: " + userId + " not found! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
		closeTransactionSession();
		return user;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void update(User user) {
		
		Session session = openTransactionSession();
		try {
	        session.update(user);
	        log.info("User has been updated successfully!");
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("User not updated! " + e.getMessage());
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
		try {
			Query query = session.createQuery("delete from User u where u.id = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	        log.info("User has been deleted successfully!");
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("User not deleted! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public List<User> getAll() {
		Session session = openTransactionSession();
		List<User> users = null;
		try {
			users = session.createQuery("from User", User.class).list();
			log.info("User list was recieved successfully!");
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("User list not received!" + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
		return users;
	}
}
