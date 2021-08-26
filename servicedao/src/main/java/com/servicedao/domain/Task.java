package com.servicedao.domain;

import java.util.Objects;

public class Task {
	private int id;
	private int userId;
	private String title;
	private String description;

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
