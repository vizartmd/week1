package com.servicedao.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import com.servicedao.dao.TaskDAO;
import com.servicedao.domain.Task;
import com.servicedao.hibernate.SessionUtil;

/**
 * @inheritDoc
 */
public class MySQLTaskDAOImpl extends SessionUtil implements TaskDAO {

	static Logger log = Logger.getLogger(MySQLTaskDAOImpl.class.getName());

	@Override
	public void insert(Task task) {
		Session session = openTransactionSession();
		session.save(task);
		session.flush();
		closeTransactionSession();
	}

	@Override
	public Task getById(int id) {
		Session session = openTransactionSession();
		Query query = session.createQuery("from Task t where t.id = :id");
		query.setParameter("id", id);
		Task task = (Task) query.getSingleResult();
		closeTransactionSession();
		return task;
	}

	@Override
	public void update(Task task) {
		Session session = openTransactionSession();
		String hql = "update Task set title = :title, description = :description where id = :taskId";
		Query query = session.createQuery(hql);
		query.setParameter("title", task.getTitle());
		query.setParameter("description", task.getDescription());
		query.setParameter("taskId", task.getId());
		query.executeUpdate();
		closeTransactionSession();
	}

	@Override
	public void deleteById(int id) {
		Session session = openTransactionSession();
		Query query = session.createQuery("delete from Task t where t.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		session.flush();
		closeTransactionSession();
	}

	@Override
	public List<Task> getAll() {
		Session session = openTransactionSession();
		return session.createQuery("from Task", Task.class).list();
	}
}
