package com.juan.sanchez.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Profile("aop-before")
public class LoggingAuthorAspectBefore {

    @Before("execution(* com.juan.sanchez.service.AuthorService.find*(..))")
    void beforeAdvice(JoinPoint jp) {
        System.out.printf("[%s] beforeAdvice Starting %n", this.getClass().getSimpleName());
        System.out.printf(" Target Name: %s%n", jp.getTarget());
        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
        System.out.printf("[%s] beforeAdvice Ending %n", this.getClass().getSimpleName());
    }

}
