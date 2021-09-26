package com.servicedao.aspects;

import java.io.IOException;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.email.EmailUtil;
import com.servicedao.email.MailSender;

@Aspect
public class MyAspect {

	private Object[] callerArgs;

//	@Before("execution(* *.addTasksToUser(..))")
	@Before("execution(* *.addTasksToUser(..)) && @annotation(com.servicedao.annotations.AvailableForAspect)")
	public void logBefore(JoinPoint joinPoint)
			throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IOException {
		
		callerArgs = joinPoint.getArgs();
		Set<Task> tasks = (Set<Task>) callerArgs[0];
		User user = (User) callerArgs[1];
		String mail = EmailUtil.UserStringFormatter(tasks, user);
		MailSender.sendEmail(mail, user.getUserName());
	}
}