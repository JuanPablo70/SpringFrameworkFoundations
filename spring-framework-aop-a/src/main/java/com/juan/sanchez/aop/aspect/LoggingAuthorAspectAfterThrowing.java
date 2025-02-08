package com.juan.sanchez.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Profile("aop-after-throwing")
class LoggingAuthorAspectAfterThrowing {

    @AfterThrowing(pointcut="execution(* com.juan.sanchez.service.AuthorService.find*(..))",
            throwing="exception")
    void afterThrowingAdvice(JoinPoint jp, Exception exception) {
        System.out.printf("[%s] afterThrowingAdvice Starting %n", this.getClass().getSimpleName());
        System.out.printf(" Target Name: %s%n", jp.getTarget());
        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
        System.out.printf(" Exception  : %s%n", exception.getClass());
        System.out.printf("  Message   : %s%n", exception.getMessage());
        System.out.printf("[%s] afterThrowingAdvice Ending %n", this.getClass().getSimpleName());
    }

}
