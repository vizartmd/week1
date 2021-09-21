package com.servicedao.dao;

import java.util.List;

import com.servicedao.domain.Task;

public interface TaskDao extends DAO<Task>{

	List<Task> getUsersTask(int userId);

}
