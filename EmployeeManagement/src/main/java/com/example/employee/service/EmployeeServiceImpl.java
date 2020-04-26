package com.example.employee.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceImpl {
	Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut(value="execution(* com.example.employee.dao.*.*())")
	public void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void before(JoinPoint thePoint) {	
		String themethod = thePoint.getSignature().toString();
		logger.info("===> in @Before : calling method  "+ themethod);
	}
}
