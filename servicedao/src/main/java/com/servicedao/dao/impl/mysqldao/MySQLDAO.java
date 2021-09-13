package com.servicedao.dao.impl.mysqldao;

import java.util.List;
import com.servicedao.dao.DAO;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class MySQLDAO<T> implements DAO<T> {
	MySQLUserDAOImpl mySQLUserDAOImpl;
	MySQLTaskDAOImpl mySQLTaskDAOImpl;
	
	private static MySQLDAO instance = null;

	public MySQLDAO() {
	}
	
	public void setMySQLUserDAOImpl(MySQLUserDAOImpl mySQLUserDAOImpl) {
		this.mySQLUserDAOImpl = mySQLUserDAOImpl;
	}

	public void setMySQLTaskDAOImpl(MySQLTaskDAOImpl mySQLTaskDAOImpl) {
		this.mySQLTaskDAOImpl = mySQLTaskDAOImpl;
	}


	public static MySQLDAO getInstance() {
		if (instance == null)
			instance = new MySQLDAO();
		return instance;
	}

	@Override
	public void insert(Object t) {
		if (t instanceof User) {
			t = ((User)t);
			mySQLUserDAOImpl = new MySQLUserDAOImpl();
			mySQLUserDAOImpl.insert((User)t);
		} else if (t instanceof Task) {
			t = (Task)t;
			mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
			mySQLTaskDAOImpl.insert((Task)t);
		}
		
	}

	@Override
	public Object getById(int id, Object t) {
		if (t instanceof User) {
			t = ((User)t);
			mySQLUserDAOImpl = new MySQLUserDAOImpl();
			t = mySQLUserDAOImpl.getById(id);
		} else if (t instanceof Task) {
			t = (Task)t;
			mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
			t = mySQLTaskDAOImpl.getById(id);
		}
		return t;
	}

	@Override
	public void update(Object t) {
		if (t instanceof User) {
			t = ((User)t);
			mySQLUserDAOImpl = new MySQLUserDAOImpl();
			mySQLUserDAOImpl.update((User)t);
		} else if (t instanceof Task) {
			t = (Task)t;
			mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
			mySQLTaskDAOImpl.update((Task)t);
		}
	}

	@Override
	public void deleteById(int id, Object t) {
		if (t instanceof User) {
			t = ((User)t);
			mySQLUserDAOImpl = new MySQLUserDAOImpl();
			mySQLUserDAOImpl.deleteById(id);
		} else if (t instanceof Task) {
			t = (Task)t;
			mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
			mySQLTaskDAOImpl.deleteById(id);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Object t) {
		List<T> list = null;
		if (t instanceof User) {
			mySQLUserDAOImpl = new MySQLUserDAOImpl();
			list = (List<T>) mySQLUserDAOImpl.getAll();
		} else if (t instanceof Task) {
			t = (Task)t;
			mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
			list = (List<T>) mySQLTaskDAOImpl.getAll();
		}
		return list;
	}

}
