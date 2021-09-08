package com.servicedao.domain;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class Task { 
	
	private int taskId;
	
	private String title;
	
	private String description;
	
	private User  user;

	public Task() {
	}

	public Task(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Task(String title, String description, User user) {
		this.title = title;
		this.description = description;
		this.user = user;
	}

	public Task(int taskId, String title, String description, User user) {
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.user = user;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, taskId, title, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(description, other.description) && taskId == other.taskId
				&& Objects.equals(title, other.title) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Task [task_id=" + taskId + ", title=" + title + ", description=" + description + ", user=" + user
				+ "]";
	}

	
	
}
