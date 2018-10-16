package com.example.server.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Before("common()")
    public void processBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = requestAttributes.getRequest();

        logger.info("url={},length={},ip={},method={},class={},params={}",
                httpServletRequest.getRequestURI(),
                httpServletRequest.getContentLength(),
                httpServletRequest.getRemoteAddr(),
                httpServletRequest.getMethod(),
                joinPoint.getClass(),
                joinPoint.getArgs()
                );
    }

    @After("common()")
    public void processAfter() {
        logger.info("Process controller after.");
    }

    @Pointcut("execution(public * com.example.server.controller.*.*(..))")
    public void common() {

    }

    @AfterReturning(returning = "object", pointcut = "common()")
    public void responseBefore(Object object) {
        logger.info("Response={}",object);
    }
}
