package com.example.server.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {
    @Before("execution(public * com.example.server.controller.*.*(..))")
    public void log() {
        System.out.println("Http logs print ----------------");
    }
}
