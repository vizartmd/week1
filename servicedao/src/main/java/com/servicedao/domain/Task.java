package com.servicedao.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="task_id", length=11)
	private int taskId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="tytle")
	private String tytle;
	
	@Column(name="description")
	private String description;
	
	private Set<User> users = new HashSet<User>();

	public Task() {
	}

	public Task(int userId, String tytle, String description) {
		this.userId = userId;
		this.tytle = tytle;
		this.description = description;
	}

	public Task(int taskId, int userId, String tytle, String description) {
		this.taskId = taskId;
		this.userId = userId;
		this.tytle = tytle;
		this.description = description;
	}

	public int getId() {
		return taskId;
	}

	public void setId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTytle() {
		return tytle;
	}

	public void setTytle(String tytle) {
		this.tytle = tytle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, taskId, tytle, userId);
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
		return Objects.equals(description, other.description) && taskId == other.taskId && Objects.equals(tytle, other.tytle)
				&& userId == other.userId;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", userId=" + userId + ", tytle=" + tytle + ", description=" + description + "]";
	}

}
