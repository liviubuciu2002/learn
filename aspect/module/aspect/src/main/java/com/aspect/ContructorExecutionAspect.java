package com.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ContructorExecutionAspect {


    @Before("(execution (com.test..*.*.new(..)) || execution (com.test.*.new(..))) && !within(com.aspect.*)")
    public void before(JoinPoint.EnclosingStaticPart staticPart) throws Throwable {
        int i = 0;
        i++;
        System.out.println("from Aspect; i = " + i + " ; " + staticPart.getSignature().toString());
    }


//    @Before("initialization (*.new(..)) && !within(com.aspect.*)")
//    public void initialization(JoinPoint.EnclosingStaticPart staticPart) throws Throwable {
////        System.out.println("from Aspect   " + staticPart.getSignature().toString());
////        System.out.println("from Aspect   " + staticPart.getSourceLocation());
//        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
//        for (StackTraceElement e : stack) {
//            System.out.println("from Aspect stack :  " + e);
//        }
//    }



}
