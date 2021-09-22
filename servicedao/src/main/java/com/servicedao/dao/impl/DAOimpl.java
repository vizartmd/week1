package com.servicedao.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.servicedao.dao.DAO;
import com.servicedao.domain.Task;
import com.servicedao.hibernate.SessionUtil;

/**
 * generic DAOimpl<T> class 
 * @author vrobu1
 * @version 1.0
 */
public class DAOimpl<T> extends SessionUtil implements DAO<T> {

	Class<T> clazz;

	private Session session;

	protected DAOimpl(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public T findById(int id) {
        T t = null;
        try {
        	session = openTransactionSession();
            t = (T) session.find(clazz, id);
        } catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
        } finally {
            closeTransactionSession();
        }
        return t;
    }

	@Override
	public List<T> getAll() {
		List<T> objects = null;
		try {
			session = openTransactionSession();
			Query query = session.createQuery("from " + clazz.getName());
			objects = query.list();
		} catch (HibernateException e) {
			System.out.println(e);
		} finally {
			closeTransactionSession();
		}
		return objects;
	}

	@Override
	public void insert(T t) {
		session = openTransactionSession();
		session.saveOrUpdate(t);
		closeTransactionSession();
	}

	@Override
	public void update(T t) {
		session = openTransactionSession();
		session.update(t);
		closeTransactionSession();
	}

	@Override
	public void delete(T t) {
		session = openTransactionSession();
		session.delete(t);
		closeTransactionSession();
	}

	@Override
	public void deleteById(int id) {
		T t = null;
        try {
        	session = openTransactionSession();
            t = (T) session.find(clazz, id);
            System.out.println("t = " + t);
            session.delete(t);
        } catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
        } finally {
            closeTransactionSession();
        }
	}
}
