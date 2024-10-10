package com.example.rest.aspects;

import com.example.rest.service.PaymentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceLoggingAspect {

    private Logger logger = LoggerFactory.getLogger(ServiceLoggingAspect.class);

    @Pointcut(
            "execution(* com.example.rest.service.*.* (..))"
    )
    public void logServiceMethods() {}

    @Before("logServiceMethods()")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        logger.info("Entering: {} with params: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @After("logServiceMethods()")
    public void logAfterServiceMethod(JoinPoint joinPoint) {
        logger.info("Exiting: {}", joinPoint.getSignature());
    }
}
