package com.servicedao.service.impl;

import org.apache.log4j.Logger;
import com.servicedao.dao.TaskDao;
import com.servicedao.domain.Task;
import com.servicedao.service.TaskService;
import java.util.List;
import com.servicedao.dao.impl.TaskDaoImpl;

public class TaskServiceImpl implements TaskService {

	private Logger logger;
	private TaskDao taskDao;

	private TaskServiceImpl() {
	}

	private final static class SingletonHolder {
		private final static TaskServiceImpl INSTANCE = new TaskServiceImpl();
	}

	public static TaskServiceImpl getInstance() {
		TaskServiceImpl taskService = SingletonHolder.INSTANCE;
		
		if (taskService.logger == null) {
			taskService.logger = Logger.getLogger(TaskService.class);
		}
		if (taskService.taskDao == null) {
			taskService.taskDao = new TaskDaoImpl();
		}
		return taskService;
	}

	@Override
	public void insert(Task task) {
		taskDao.insert(task);
		logger.info("TaskService.insert() method called");
	}

	@Override
	public Task getById(int id) {
		logger.info("TaskService.getById() method called");
		return taskDao.getById(id);
	}

	@Override
	public void update(Task t) {
		logger.info("TaskService.update() method called");
		taskDao.update(t);
	}

	@Override
	public void deleteById(int id) {
		logger.info("TaskService.deleteById() method called");
		taskDao.deleteById(id);		
	}

	@Override
	public List<Task> getAll() {
		logger.info("TaskService.getAll() method called");
		return taskDao.getAll();
	}

}
