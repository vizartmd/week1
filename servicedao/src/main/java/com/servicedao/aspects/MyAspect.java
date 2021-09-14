package com.servicedao.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import com.servicedao.domain.User;
import com.servicedao.email.MailSender;

@Aspect
public class MyAspect {

	private Object[] callerArgs;

	@Before("execution(* *.insert(..)) && @annotation(com.servicedao.annotations.AvailableForAspect)")
	public void logBefore(JoinPoint joinPoint)
			throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		callerArgs = joinPoint.getArgs();
		User user = (User) callerArgs[0];
		String mail = UserStringForEmailFormatter.UserStringFormatter(user);
		MailSender.sendEmail(mail, user.getUserName());
	}
}