package com.servicedao.aspects;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Set;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import com.servicedao.annotations.AvailableForAspect;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.email.EmailUtil;
import com.servicedao.email.MailSender;

@Aspect
public class MyAspect {

	private Object[] callerArgs;

//	@Before("execution(* *.addTasksToUser(..))")
	@Before("execution(* *.*(..)) && @annotation(com.servicedao.annotations.AvailableForAspect)")
	public void logBefore(JoinPoint joinPoint)
			throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IOException {
		final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		final String methodName = signature.getName();
		if (methodName.equals("addTasksToUser")) {
			System.out.println("methodName from aspect = " + methodName);
			Parameter[] parameters = signature.getMethod().getParameters();
			callerArgs = joinPoint.getArgs();
			Set<Task> tasks = null;
			User user = null;
			for (Object o : callerArgs) {
				if (o instanceof User) {
					user = (User) o;
				} else {
					tasks = (Set<Task>) o;
				}
			}
			callerArgs = joinPoint.getArgs();
			String mail = EmailUtil.UserStringFormatter(tasks, user);
			MailSender.sendEmail(mail, user.getUserName());
		}
	}
}