package com.servicedao.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

	@Before("execution(* com.servicedao.dao.impl.MySQLUserDAOImpl.createUserAndAddHimTasks(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("Here will be method for send email" + joinPoint.toString());
    }
}
