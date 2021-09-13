package com.servicedao.aspects;

import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.email.MailSender;

@Aspect
public class MyAspect {
	
	 private Object[] callerArgs;

	@Before("execution(public void com.servicedao.dao.impl.mysqldao.MySQLDAO.insert(..))")
    public void logBefore(JoinPoint joinPoint) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
	    callerArgs = joinPoint.getArgs();
        System.out.println("Here will be method for send email" + joinPoint.toString() + ", " + callerArgs[0]);
        
        User user = (User) callerArgs[0];
		String stringForEail = "User { first name: " + user.getFirstName() + " } / {last name: " + user.getLastName() + " } identified by { user name: " + user.getUserName() + " } has been created\n\n";
        
		Set<Task> tasks = user.getTasks();
        StringBuilder sb = new StringBuilder();
		for (Task task : tasks) {
			sb.append("Task { task title: " + task.getTitle() + " } { task description: " + task.getDescription() + " } has been assigned to { user name: " + user.getUserName() + " }\n\n");
		}

		System.out.println(stringForEail + sb.toString());
		String mail = stringForEail + sb.toString();
		
		MailSender mailSender = new MailSender();
		mailSender.sendEmail(mail);
    }
}
