package com.servicedao.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mytasks")
public class Task { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "taskId")
	private int taskId;
	
	@Column(name = "title", unique = false, nullable = false, length = 100)
	private String title;
	
	@Column(name = "description", unique = false, nullable = false, length = 250)
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
		return Objects.hash(description, taskId, title);
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
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", title=" + title + ", description=" + description + "]";
	}

	

	
	
}
