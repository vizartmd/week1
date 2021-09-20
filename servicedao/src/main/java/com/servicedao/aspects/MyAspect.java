package com.servicedao.aspects;

import java.io.IOException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.servicedao.domain.User;
import com.servicedao.email.EmailUtil;
import com.servicedao.email.MailSender;

@Aspect
public class MyAspect {

	private Object[] callerArgs;

//	@Before("execution(* *.insert(..))")
	@Before("@annotation(com.servicedao.annotations.AvailableForAspect)")
	public void logBefore(JoinPoint joinPoint)
			throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IOException {
		
		callerArgs = joinPoint.getArgs();
		User user = (User) callerArgs[0];
		String mail = EmailUtil.UserStringFormatter(user);
		MailSender.sendEmail(mail, user.getUserName());
	}
}