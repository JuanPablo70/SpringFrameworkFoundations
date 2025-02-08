package com.juan.sanchez.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Profile("aop-before")
public class LoggingAuthorAspectBefore {

    //A
//    @Before("execution(* com.juan.sanchez.service.AuthorService.find*(..))")
//    void beforeAdviceFinds(JoinPoint jp) {
//        System.out.printf("[%s] beforeAdvice Starting %n", this.getClass().getSimpleName());
//        System.out.printf(" Target Name: %s%n", jp.getTarget());
//        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
//        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
//        System.out.printf("[%s] beforeAdvice Ending %n", this.getClass().getSimpleName());
//    }
//
//    @Before("execution(* com.juan.sanchez.service.AuthorService.count(..))")
//    void beforeAdviceCount(JoinPoint jp) {
//        System.out.printf("[%s] beforeAdvice Starting %n", this.getClass().getSimpleName());
//        System.out.printf(" Target Name: %s%n", jp.getTarget());
//        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
//        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
//        System.out.printf("[%s] beforeAdvice Ending %n", this.getClass().getSimpleName());
//    }

    //B
//    @Before("authorServiceFinds()")
//    void beforeAdviceFinds(JoinPoint jp) {
//        System.out.printf("[%s] beforeAdvice Starting %n", this.getClass().getSimpleName());
//        System.out.printf(" Target Name: %s%n", jp.getTarget());
//        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
//        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
//        System.out.printf("[%s] beforeAdvice Ending %n", this.getClass().getSimpleName());
//    }
//
//    @Before("authorServiceCount()")
//    void beforeAdviceCount(JoinPoint jp) {
//        System.out.printf("[%s] beforeAdvice Starting %n", this.getClass().getSimpleName());
//        System.out.printf(" Target Name: %s%n", jp.getTarget());
//        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
//        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
//        System.out.printf("[%s] beforeAdvice Ending %n", this.getClass().getSimpleName());
//    }
//
//    @Pointcut("execution(* com.juan.sanchez.service.AuthorService.find*(..))")
//    private void authorServiceFinds() {
//
//    }
//
//    @Pointcut("execution(* com.juan.sanchez.service.AuthorService.count(..))")
//    private void authorServiceCount() {
//
//    }

    //C
//    @Before("com.juan.sanchez.aop.pointcut.AuthorPointcut.authorServiceFinds()")
//    void beforeAdviceFinds(JoinPoint jp) {
//        System.out.printf("[%s] beforeAdvice Starting %n", this.getClass().getSimpleName());
//        System.out.printf(" Target Name: %s%n", jp.getTarget());
//        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
//        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
//        System.out.printf("[%s] beforeAdvice Ending %n", this.getClass().getSimpleName());
//    }
//
//    @Before("com.juan.sanchez.aop.pointcut.AuthorPointcut.authorServiceCount()")
//    void beforeAdviceCount(JoinPoint jp) {
//        System.out.printf("[%s] beforeAdvice Starting %n", this.getClass().getSimpleName());
//        System.out.printf(" Target Name: %s%n", jp.getTarget());
//        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
//        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
//        System.out.printf("[%s] beforeAdvice Ending %n", this.getClass().getSimpleName());
//    }

    //D
    @Before("com.juan.sanchez.aop.pointcut.AuthorPointcut.authorServiceCount() ||" +
            "com.juan.sanchez.aop.pointcut.AuthorPointcut.authorServiceFinds()")
    void beforeAdvice(JoinPoint jp) {
        System.out.printf("[%s] beforeAdvice Starting %n", this.getClass().getSimpleName());
        System.out.printf(" Target Name: %s%n", jp.getTarget());
        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
        System.out.printf("[%s] beforeAdvice Ending %n", this.getClass().getSimpleName());
    }


}
