package com.servicedao.service;

import java.util.List;

/**
 * @author vrobu1
 * Class-Invoker UserDAO class. "Command"-Pattern
 */

import com.servicedao.command.usercommand.CommandUserDelete;
import com.servicedao.command.usercommand.CommandUserGetAll;
import com.servicedao.command.usercommand.CommandUserGetById;
import com.servicedao.command.usercommand.CommandUserInsert;
import com.servicedao.command.usercommand.CommandUserUpdate;
import com.servicedao.dao.MySQLUserDAO;
import com.servicedao.daointf.UserDAO;
import com.servicedao.domain.User;

public class UserServiceInvoker implements UserDAO {
	MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
	CommandUserInsert commandUserInsert;
	CommandUserGetById commandUserGetById;
	CommandUserUpdate commandUserUpdate;
	CommandUserDelete commandUserDelete;
	CommandUserGetAll commandUserGetAll;

	@Override
	public void insert(User user) {
		commandUserInsert = new CommandUserInsert(mySQLUserDAO, user);
		commandUserInsert.execute();
	}

	@Override
	public User getById(int id) {
		commandUserGetById = new CommandUserGetById(mySQLUserDAO, id);
		commandUserGetById.execute();
		return commandUserGetById.getUser();
	}

	@Override
	public void update(User user, int id) {
		commandUserUpdate = new CommandUserUpdate(mySQLUserDAO, user, id);
		commandUserUpdate.execute();
	}

	@Override
	public void deleteById(int id) {
		commandUserDelete = new CommandUserDelete(mySQLUserDAO, id);
		commandUserDelete.execute();
	}

	@Override
	public List<User> getAll() {
		commandUserGetAll = new CommandUserGetAll(mySQLUserDAO);
		commandUserGetAll.execute();
		return commandUserGetAll.getUsers();
	}

}
