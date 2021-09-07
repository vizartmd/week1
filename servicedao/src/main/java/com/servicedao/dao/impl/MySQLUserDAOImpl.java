package com.servicedao.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import com.servicedao.dao.UserDAO;
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
		session.save(user);
		closeTransactionSession();
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public User getById(int id) {
		Session session = openTransactionSession();
//		Query query = session.createQuery("from User u where u.id = :id");
//		query.setParameter("id", id);
//		User user = (User) query.getSingleResult();
		User user = session.get(User.class, id);
		session.flush();
		closeTransactionSession();
		return user;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void update(User user) {
		Session session = openTransactionSession();
		String hql = "update User set firstName = :firstName, lastName = :lastName, userName = :userName where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("firstName", user.getFirstName());
		query.setParameter("lastName", user.getLastName());
		query.setParameter("userName", user.getUserName());
		query.setParameter("id", user.getId());
		query.executeUpdate();
		closeTransactionSession();
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
		session.flush();
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
