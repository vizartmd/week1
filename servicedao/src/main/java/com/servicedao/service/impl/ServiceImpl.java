package com.servicedao.service.impl;

import java.util.List;

import com.servicedao.dao.DAO;
import com.servicedao.dao.DAOFactory;
import com.servicedao.enums.DatabaseTypes;
import com.servicedao.service.Service;

public class ServiceImpl<T> implements Service<T, DatabaseTypes> {
	DAO<T> dao;

	@Override
	public void insert(T t, DatabaseTypes databaseType) {
		dao = new DAOFactory().getDAOFactory(databaseType);
		dao.insert(t);
	}

	@Override
	public T getById(int id, T t, DatabaseTypes databaseType) {
		dao = new DAOFactory().getDAOFactory(databaseType);
		return dao.getById(id, t);
	}

	@Override
	public void update(T t, DatabaseTypes databaseType) {
		dao = new DAOFactory().getDAOFactory(databaseType);
		dao.insert(t);
		
	}

	@Override
	public void deleteById(int id, T t, DatabaseTypes databaseType) {
		new DAOFactory();
		dao = DAOFactory.getDAOFactory(databaseType);
		dao.deleteById(id, t);
	}

	@Override
	public List<T> getAll(T t, DatabaseTypes databaseType) {
		dao = new DAOFactory().getDAOFactory(databaseType);
		return dao.getAll(t);
	}
}
