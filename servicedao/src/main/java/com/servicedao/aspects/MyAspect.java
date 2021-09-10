package com.servicedao.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

	@Pointcut("execution(* *.*(..))")
    void anyMethodCall() {
    }

    @Before("getAll()")
    public void beforeMethod() {
        System.out.println("Aspect Before Method");
    }
	
}
