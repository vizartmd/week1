package com.servicedao.daointf;

import java.util.List;

public interface DAOIntf<T> {
	
	/**
	 * @inherited
	 * method "insert()" allows to insert a new <T> Object in database
	 * @param t the <T> Object to be inserted in database
	 */
	public void insert(T t);


	/**
	 * @inherited
	 * method "getById()" allows to get a <T> Object from the database by id
	 * @param id to find a Task Object from the database by unique id
	 */
	public T getById(int id); 

	/**
	 * @inherited
	 * method "update()" allows to update a <T> Object in the database
	 * @param t the <T> Object to be updated in database
	 */
	public void update(T t);

	/**
	 * @inherited
	 * method "deleteById()" allows to delete a <T> Object from the database by id
	 * @param id to find a Task Object from the database by unique id
	 */
	public void deleteById(int id);
	

	/**
	 * @inherited
	 * method "getAll()" allows to get all of the <T> Objects from the database
	 * @return {@link List} of all of the <T> Objects
	 */
	public List<T> getAll();
}
