package com.juan.sanchez.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Profile("aop-after")
class LoggingAuthorAspectAfter {

    @After("execution(* com.juan.sanchez.service.AuthorService.find*(..))")
    void afterAdvice(JoinPoint jp) {
        System.out.printf("[%s] afterAdvice Starting %n", this.getClass().getSimpleName());
        System.out.printf(" Target Name: %s%n", jp.getTarget());
        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
        System.out.printf("[%s] afterAdvice Starting %n", this.getClass().getSimpleName());
    }

}
