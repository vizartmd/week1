package com.servicedao.domain;

import java.util.Set;

@ReadyForReflection
public class User {
	
	private int userId;

	private String firstName;

	private String lastName;

	private String userName;

	private Set<Task> tasks;

	public User() {
	}

	public User(String firstName, String lastName, String userName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}

	public User(String firstName, String lastName, String userName, Set<Task> tasks) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.tasks = tasks;
	}

	public User(int userId, String firstName, String lastName, String userName, Set<Task> tasks) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.tasks = tasks;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", tasks=" + tasks + "]";
	}
	
	public String toStringForEmail() {
		return "User (first name: " + firstName + ") / {last name: " + lastName + "} identified by {user name: " + userName + "} has been created\n\n" + printTasks(tasks);
	}
	
	private String printTasks(Set<Task> tasks) {
		StringBuilder sb = new StringBuilder();
		for (Task task : tasks) {
			sb.append("Task {task title: " + task.getTitle() + "} {task description: " + task.getDescription() + "} has been assigned to {user name: " + getUserName() + "}\n\n");
		}
		return sb.toString();
	}
	
}
