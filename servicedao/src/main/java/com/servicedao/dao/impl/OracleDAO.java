package com.servicedao.dao.impl;

import java.util.List;
import com.servicedao.dao.DAO;

public class OracleDAO<T> implements DAO<T> {
	private static OracleDAO instance = null;

	public OracleDAO() {
	}


	public static OracleDAO getInstance() {
		if (instance == null)
			instance = new OracleDAO();
		return instance;
	}

	@Override
	public void insert(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getById(int id, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id, Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getAll(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

}
