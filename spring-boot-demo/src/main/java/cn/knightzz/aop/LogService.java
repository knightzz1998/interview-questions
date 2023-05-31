package cn.knightzz.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 王天赐
 * @title: LogService
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-05-31 11:27
 */
@Order(1)
@Component
@Aspect
public class LogService {

    @Pointcut(value = "execution(* cn.knightzz.service.*.*(..))")
    public void pointService() {
    }

    ;

    @Before(value = "pointService()")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("AOP before ====>");
        System.out.println(signature.getName());
    }
}

