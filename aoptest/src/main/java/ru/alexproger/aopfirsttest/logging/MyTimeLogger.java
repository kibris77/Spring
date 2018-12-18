package ru.alexproger.aopfirsttest.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@Aspect
public class MyTimeLogger {

    @Pointcut("execution(* ru.alexproger.aopfirsttest.objects.Manager.*(..))")
    private void allMethods() {

    }

    @Around("allMethods() && execution(java.util.Map *(..)))")
    public Object watchTime(ProceedingJoinPoint joinpoint) {
        long start = System.currentTimeMillis();
        System.out.println("method begin: " + joinpoint.getSignature().toShortString());
        Object output = null;
        try {
            output = joinpoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("method end: " + joinpoint.getSignature().toShortString() + ", time=" + time + " ms");

        return output;
    }

    @AfterReturning(pointcut = "allMethods() && execution(java.util.Map *(..))))", returning = "obj")
    public void print(Object obj) {
        System.out.println("Print info begin >>");
        Map map = (Map) obj;
        for (Object object : map.keySet()) {
            System.out.println("key=" + object + ", " + map.get(object));

        }
        System.out.println("Print info end <<");
        System.out.println();
    }
    @AfterReturning(pointcut = "allMethods() && execution(java.util.Set *(..))))", returning = "obj")
    public void printSet(Object obj) {
        System.out.println("Print info begin >>");
        Set set = (Set) obj;
        for (Object object : set) {
            System.out.println(object);
        }
        System.out.println("Print info end <<");
        System.out.println();
    }
}
