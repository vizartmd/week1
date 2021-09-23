package com.servicedao.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.servicedao.dao.DAO;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.hibernate.SessionUtil;

/**
 * generic DAOimpl class 
 * @author vrobu1
 * @version 1.0
 */
public class DAOimpl<T> extends SessionUtil implements DAO<T> {

	private Class<T> clazz;
	private Session session;
	private CriteriaBuilder criteriaBuilder;

	protected DAOimpl(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public T findById(int id) {
        return null;
    }
	
	@Override
	public Set<T> getAll() {
		List<T> results = null;
		Set<T> setItems = null;
		try {
			session = openTransactionSession();
			criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<T> cr = criteriaBuilder.createQuery(clazz);
			Root<T> root = cr.from(clazz);
			cr.select(root);
			Query<T> query = session.createQuery(cr);
			results = query.getResultList();
			setItems = (Set<T>) new HashSet<>(results);
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			closeTransactionSession();
		}
		return (Set<T>) setItems;
	}

	@Override
	public void insert(T t) {
		session = openTransactionSession();
		try {
			session.save(t);
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			closeTransactionSession();
		}
	}

	@Override
	public void update(T t) {
		session = openTransactionSession();
		try {
			session.update(t);
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			closeTransactionSession();
		}
	}

	@Override
	public void delete(T t) {
		session = openTransactionSession();
		try {
			session.delete(t);
		} catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			closeTransactionSession();
		}
	}

	@Override
	public void deleteById(int id) {
		
	}
}
