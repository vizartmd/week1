package com.servicedao.dao.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import com.servicedao.dao.DAO;
import com.servicedao.hibernate.SessionUtil;

public abstract class DAOimpl<T> extends SessionUtil implements DAO<T> {
	
	Logger logger = Logger.getLogger(DAOimpl.class);
	private Class<T> clazz;

    protected DAOimpl(Class<T> clazz) {
        this.clazz = clazz;
    }

	@Override
	public T findById(int id) {
		Session session = openTransactionSession();
        T t = session.get(clazz, id);
        closeTransactionSession();
		return null;
	}

	@Override
	public List<T> getAll() {
		Session session = openTransactionSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(clazz);
        criteriaQuery.from(clazz);
        List<T> ts = session.createQuery(criteriaQuery).getResultList();

        session.close();
        return ts;
	}

	@Override
	public void insert(T t) {
		Session session = openTransactionSession();
        session.saveOrUpdate(t);
        closeTransactionSession();
	}

	@Override
	public void update(Object t) {
		Session session = openTransactionSession();
        session.update(t);
        closeTransactionSession();
	}

	@Override
	public void deleteById(int id) {
		Session session =  openTransactionSession();
        session.delete(id);
        closeTransactionSession();
	}
}
