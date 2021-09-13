package com.main.command;

import com.servicedao.enums.DatabaseTypes;
import com.servicedao.service.impl.ServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with T class
 * It has a single method "execute()" that calls the "update()" method on
 * the ServiceImpl class from the service layer and update T object
 */
public class UpdateCommand<T> implements Command {

	private ServiceImpl serviceImpl;
	private DatabaseTypes databaseType;
	private int id;
	T t;
	
	public UpdateCommand(DatabaseTypes databaseType, int id, T t) {
		this.databaseType = databaseType;
		this.id = id;
		this.t = t;
	}

	@Override
	public void execute() {
		serviceImpl = new ServiceImpl();
		serviceImpl.update(t, databaseType);
	}
}
