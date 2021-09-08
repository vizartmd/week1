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
	
	private int userId;
	
	private int taskId;
	
	private String title;
	
	private String description;

	public Task() {
	}

	public Task(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Task(int taskId, String title, String description) {
		this.taskId = taskId;
		this.title = title;
		this.description = description;
	}

	public Task(int userId, int taskId, String title, String description) {
		this.userId = userId;
		this.taskId = taskId;
		this.title = title;
		this.description = description;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public int hashCode() {
		return Objects.hash(description, taskId, title, userId);
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
				&& Objects.equals(title, other.title) && userId == other.userId;
	}

	@Override
	public String toString() {
		return "Task [userId=" + userId + ", taskId=" + taskId + ", title=" + title + ", description=" + description
				+ "]";
	}

	

	
	
}
