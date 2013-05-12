package com.jorgesilva.sandbox;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * TODO: doc
 *
 * @author Jorge Silva <juniorjoca at gmail dot com>
 */
@Aspect
public class DemoAspect {

    @Before("execution(* com.jorgesilva.sandbox.AdvisedBean.sayHello())")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @After("execution(* com.jorgesilva.sandbox.AdvisedBean.sayHello())")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("logAfter() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @AfterReturning(
            pointcut = "execution(* com.jorgesilva.sandbox.AdvisedBean.sayHello())",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");
    }

    @AfterThrowing(
            pointcut = "execution(* com.jorgesilva.sandbox.AdvisedBean.sayHello())",
            throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        System.out.println("logAfterThrowing() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");

    }

//    @Around("execution(* com.jorgesilva.sandbox.AdvisedBean.sayHello())")
//    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("logAround() is running!");
//        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
//        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
//
//        System.out.println("Around before is running!");
//        joinPoint.proceed(); //continue on the intercepted method
//        System.out.println("Around after is running!");
//        System.out.println("******");
//    }
}
