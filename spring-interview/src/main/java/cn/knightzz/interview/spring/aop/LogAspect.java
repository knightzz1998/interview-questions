package cn.knightzz.interview.spring.aop;

import cn.knightzz.interview.spring.ioc.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 王天赐
 * @title: LogAspect
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-04-29 14:26
 */
@Aspect
@Component
public class LogAspect {

    @Before("execution(* cn.knightzz.interview.spring.ioc.*.*(..))")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法开始执行了...");
    }

    @After("execution(* cn.knightzz.interview.spring.ioc.*.*(..))")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法执行结束了...");
    }

    @AfterReturning(value = "execution(* cn.knightzz.interview.spring.ioc.*.*(..))", returning = "r")
    public void returing(JoinPoint joinPoint,Integer r) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法返回："+r);
    }

    @AfterThrowing(value = "execution(* cn.knightzz.interview.spring.ioc.*.*(..))", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法抛异常了："+e.getMessage());
    }

    @Around(value = "execution(* cn.knightzz.interview.spring.ioc.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("进入 around ............");
        Object[] args = pjp.getArgs();

        // 访问方法参数，可以对参数进行修改
        for (Object arg : args) {
            if(arg instanceof User) {
                System.out.println("User 对象 ==> 参数值：" + arg);
            }
        }

        Object proceed = null;
        try {
            //这个相当于 method.invoke 方法，我们可以在这个方法的前后分别添加日志，就相当于是前置/后置通知
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("离开 around ............");
        return proceed;
    }
}
