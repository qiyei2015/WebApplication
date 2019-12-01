package com.qiyei.aspectjdemo.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author Created by qiyei2015 on 2019/12/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@Aspect
public class MyAspectAnnotation {

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before(value = "execution(* com.qiyei.aspectjdemo.demo1.ProductDao.save(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知=================="+joinPoint);
    }

    /**
     * 后置通知
     */
    @AfterReturning(value = "execution(* com.qiyei.aspectjdemo.demo1.ProductDao.update(..))",returning = "result")
    public void after(Object result){
        System.out.println("后置通知=================="+result);
    }

    /**
     * 环绕通知
     */
    @Around(value = "execution(* com.qiyei.aspectjdemo.demo1.ProductDao.delete())")
    public void around(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("环绕通知前==================" + joinPoint);
            joinPoint.proceed();
            System.out.println("环绕通知后==================" + joinPoint);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @AfterThrowing(value = "myPointcut4()",throwing = "throwable")
    public void afterThrowing(Throwable throwable){
        System.out.println("异常抛出通知=============="+throwable.getMessage());
    }

    @After(value = "myPointcut5()")
    public void after(){
        System.out.println("最终通知==================");
    }

    @Pointcut(value = "execution(* com.qiyei.aspectjdemo.demo1.ProductDao.save(..))")
    private void pointCut1(){
    }

    @Pointcut(value="execution(* com.qiyei.aspectjdemo.demo1.ProductDao.update(..))")
    private void myPointcut2(){}

    @Pointcut(value="execution(* com.qiyei.aspectjdemo.demo1.ProductDao.delete(..))")
    private void myPointcut3(){}

    @Pointcut(value="execution(* com.qiyei.aspectjdemo.demo1.ProductDao.findOne(..))")
    private void myPointcut4(){}

    @Pointcut(value="execution(* com.qiyei.aspectjdemo.demo1.ProductDao.findAll(..))")
    private void myPointcut5(){}
}
