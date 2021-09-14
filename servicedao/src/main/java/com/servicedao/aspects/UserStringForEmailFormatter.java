package com.servicedao.aspects;

import java.util.Set;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class UserStringForEmailFormatter {

	public static String UserStringFormatter(User user) {

		String stringForEail = "User { first name: " + user.getFirstName() + " } / {last name: " + user.getLastName()
				+ " } identified by { user name: " + user.getUserName() + " } has been created\n\n";

		Set<Task> tasks = user.getTasks();
		StringBuilder sb = new StringBuilder();
		for (Task task : tasks) {
			sb.append("Task { task title: " + task.getTitle() + " } { task description: " + task.getDescription()
					+ " } has been assigned to { user name: " + user.getUserName() + " }\n\n");
		}
		return stringForEail + sb.toString();
	}

}
