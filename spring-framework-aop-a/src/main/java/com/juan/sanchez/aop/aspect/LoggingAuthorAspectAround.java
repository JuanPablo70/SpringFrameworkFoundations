package com.juan.sanchez.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Profile("aop-around")
class LoggingAuthorAspectAround {

    @Around("execution(* com.juan.sanchez.service.AuthorService.find*(..))")
    Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.printf("[%s] aroundAdvice Starting %n", this.getClass().getSimpleName());
        System.out.printf(" Target Name: %s%n", pjp.getTarget());
        System.out.printf(" Method Name: %s%n", pjp.getSignature().getName());
        System.out.printf(" Args       : %s%n", Arrays.asList(pjp.getArgs()));
        Object object = null;
        try {
            object = pjp.proceed();
            System.out.printf(" Returned   : %s%n", object);
        }
        catch(Throwable t) {
            System.out.printf(" Throwable %n");
            System.out.printf("  Class     : %s%n", t.getClass());
            System.out.printf("  Message   : %s%n", t.getMessage());
            throw t;
        }
        finally {
            System.out.printf("[%s] aroundAdvice Ending %n", this.getClass().getSimpleName());
        }
        return object;
    }

}
