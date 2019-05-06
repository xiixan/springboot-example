package com.superface.example.aspect;

import java.lang.reflect.Method;

import com.superface.example.annotation.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * LogAspect
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.superface.example.annotation.Log)")
    public void logPointcut(){
    }

    @Around("logPointcut()")
    public Object LogHandle(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Around before");
        Object rtv = point.proceed();
        System.out.println("Around after");
        return rtv;
    }
    
}