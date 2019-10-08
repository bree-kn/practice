package com.example.practice.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Aop面向切面编程，扩展功能不修改源代码实现。
 * 底层使用动态代理方法实现。
 * 连接点：类里边有哪些方法可以被增强，这些方法称为连接点。
 * 切入点：在类里边有很多的方法被增强，可是只增强了部分的方法，实际增强的方法为切入点。
 * 通知/增强：增强的逻辑称为增强，比如扩展日志的功能
 */

@Aspect
@Component
public class Aop1 {
    private static final Logger log = LoggerFactory.getLogger(Aop1.class);

    @Pointcut("execution(* com.example.practice.*.*.*(..))")//需要写具体包下的类的方法
    public void print(){

    }

    @Before("print()")
    public void before(JoinPoint joinPoint){
        Signature sig = joinPoint.getSignature();
        String method = joinPoint.getTarget().getClass().getName()+"."+sig.getName();
        log.info("前置切面before "+method);
    }
//@After 最终通知。当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
    @After("print()")
    public void after(JoinPoint joinPoint){
        log.info("后置切面after "+new Date(System.currentTimeMillis()));
    }

    //在连接点正常执行完成后执行的通知
    @AfterReturning("print()")
    public void afterReturn(JoinPoint joinPoint){
        log.info("AfterReturning"+new Date(System.currentTimeMillis()));
    }
//    异常通知：在方法抛出异常退出时执行的通知。
    @AfterThrowing("print()")
    public void afterThrow(JoinPoint joinPoint){
        log.info("AfterThrowing"+new Date(System.currentTimeMillis()));
    }

    @Around("print()")
    public void round(ProceedingJoinPoint pj) throws Throwable {
      log.info("环绕切面around开始");
      pj.proceed();//执行方法。
        System.out.println("环绕通知结束");
    }
}
