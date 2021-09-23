package com.servicedao.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id", unique = true, nullable = false)
	private int taskId;

	@Column(name = "title", unique = false, nullable = false, length = 100)
	private String title;

	@Column(name = "description", unique = false, nullable = false, length = 250)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	@JoinColumn(name = "user_id")
	private User user;

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

	public Task(int user_id, int taskId, String title, String description) {
		this.taskId = taskId;
		this.title = title;
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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

	@Override
	public String toString() {
		return "\nTask [taskId=" + taskId + ", title=" + title + ", description=" + description + "]";
	}

}
