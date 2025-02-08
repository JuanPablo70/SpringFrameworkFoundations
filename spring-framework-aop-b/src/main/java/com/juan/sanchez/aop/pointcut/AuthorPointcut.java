package com.juan.sanchez.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class AuthorPointcut {

    @Pointcut("execution(* com.juan.sanchez.service.AuthorService.count(..))")
    public void authorServiceCount() {

    }

    @Pointcut("execution(* com.juan.sanchez.service.AuthorService.find*(..))")
    public void authorServiceFinds() {

    }

}
