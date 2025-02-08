package com.juan.sanchez.aop.aspect;

import com.juan.sanchez.domain.Author;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Aspect
@Component
@Profile("aop-after-returning")
class LoggingAuthorAspectAfterReturning {

    @AfterReturning(pointcut="authorServiceFinds()",
            returning="author")
    void afterReturningAuthorAdvice(JoinPoint jp, Author author) {
        System.out.printf("[%s] afterReturningAdvice Starting %n", this.getClass().getSimpleName());
        System.out.printf(" Target Name: %s%n", jp.getTarget());
        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
        System.out.printf(" Returned   : %s%n", author);
        System.out.printf("[%s] afterReturningAdvice Ending %n", this.getClass().getSimpleName());
    }

    @AfterReturning(pointcut="authorServiceFinds()",
            returning="authors")
    void afterReturningAuthorsAdvice(JoinPoint jp, Collection<Author> authors) {
        System.out.printf("[%s] afterReturningAdvice Starting %n", this.getClass().getSimpleName());
        System.out.printf(" Target Name: %s%n", jp.getTarget());
        System.out.printf(" Method Name: %s%n", jp.getSignature().getName());
        System.out.printf(" Args       : %s%n", Arrays.asList(jp.getArgs()));
        System.out.printf(" Returned   : %s%n", authors);
        System.out.printf("[%s] afterReturningAdvice Ending %n", this.getClass().getSimpleName());
    }

    @Pointcut("execution(* com.juan.sanchez.service.AuthorService.find*(..))")
    private void authorServiceFinds() {

    }

}
