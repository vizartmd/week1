package com.servicedao.domain;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "task")
public class Task {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Column(name = "user_id")
	private int userId;
	
//	@Column(name = "title")
	private String title;
	
//	@Column(name = "description")
	private String description;
	
	@ManyToMany(mappedBy = "tasks")
	private Set<User> users;

	public Task() {
	}

	public Task(int userId, String title, String description) {
		this.userId = userId;
		this.title = title;
		this.description = description;
	}

	public Task(int id, int userId, String title, String description) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, title, userId);
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
		return Objects.equals(description, other.description) && id == other.id && Objects.equals(title, other.title)
				&& userId == other.userId;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", userId=" + userId + ", title=" + title + ", description=" + description + "]";
	}

}
