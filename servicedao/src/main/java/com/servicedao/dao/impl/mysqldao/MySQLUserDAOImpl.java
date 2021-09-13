package com.servicedao.dao.impl.mysqldao;

import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import com.servicedao.annotations.ReadyForReflection;
import com.servicedao.domain.User;
import com.servicedao.hibernate.SessionUtil;

public class MySQLUserDAOImpl extends SessionUtil {
	
	static Logger log = Logger.getLogger(MySQLUserDAOImpl.class.getName());

	public void insert(User user) {
		Session session = openTransactionSession();
		try {
	        session.save(user);
	        log.info("User has been inserted successfully!");
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			log.warn("User not inserted! " + e.getMessage());
	        System.out.println("NOT IN ASPECT! in insert(User user) meth parameters");
		} finally {
	        closeTransactionSession();
		}
	}
	
	@ReadyForReflection
	public void createUserAndAddHimTasks(User user) {
		Session session = openTransactionSession();
		try {
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

	public List<User> getAll() {
		Session session = openTransactionSession();
		List<User> users = null;
		try {
			users = (List<User>) session.createQuery("from User", User.class).list();
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
