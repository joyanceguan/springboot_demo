package com.joyance.springboot.demo.proxy;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Aspect
@Component
public class AopAspect {

	public final static String URL="execution(public * com.joyance.springboot.demo.mapper.*.*(..))";

	@Around(URL)
    public Object invoke(ProceedingJoinPoint point) throws Throwable{
		Object[] args = point.getArgs();
		Signature signature = point.getSignature();
		MethodSignature ms = (MethodSignature)signature;
		Method method = ms.getMethod();
		Object obj = point.proceed(args);
		System.out.println("aop拦截方法:"+method.getName()+",入参:"+JSON.toJSONString(args)+",出参:"+JSON.toJSONString(obj));
	    return obj;	
    }
}
