package com.yujianfei.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.yujianfei.annotation.Action;

@Aspect
@Component
public class LogAspect {

	// 定义切面，通过自定义注解方式
	@Pointcut("@annotation(com.yujianfei.annotation.Action)")
	public void annotationPointCut() {}
	
	@Before("annotationPointCut()")
	public void before_annotation(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("注解式拦截 " + action.name());
	}
	
	@Before("execution(* com.yujianfei.aop.DemoMethodService.*(..))")
	public void before_method(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则式拦截," + method.getName());
	}
}
