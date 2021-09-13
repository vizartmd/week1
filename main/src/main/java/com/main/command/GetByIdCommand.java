package com.main.command;

import com.servicedao.enums.DatabaseTypes;
import com.servicedao.service.impl.ServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with T class
 * It has a single method "execute()" that calls the "getById()" method on
 * the ServiceImpl class from the service layer
 */
public class GetByIdCommand<T> implements Command {

	private ServiceImpl serviceImpl;
	private DatabaseTypes databaseType;
	private int id;
	T t;
	
	public GetByIdCommand(DatabaseTypes databaseType, int id, T t) {
		this.databaseType = databaseType;
		this.id = id;
		this.t = t;
	}

	public T getItem() {
		return t;
	}

	@Override
	public void execute() {
		serviceImpl = new ServiceImpl();
		this.t = (T) serviceImpl.getById(id, t, databaseType);
	}

}