package com.servicedao.service;

import java.util.List;

import com.servicedao.dao.DAO;

public interface ServiceIntf<T> {
	
	public void insert(T t);

	public T getById(int id);

	public void update(T t);

	public void deleteById(int id);

	public List<T> getAll();
}
