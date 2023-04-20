package com.vitali;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class MessageAspect {
    private long startTime;

    @Before("execution(* com.vitali.MessageService.send(..))")
    public void beforeSend() {
        log.info("Before send method is called");
        startTime = System.currentTimeMillis();
    }

    @After("execution(* com.vitali.MessageService.send(..))")
    public void afterSend() {
        log.info("After send method is called");
    }

    @AfterReturning(pointcut = "execution(* com.vitali.MessageService.send(..))", returning = "result")
    public void afterReturningSend(Object result) {
        log.info("Message sent successfully: {}", result);
        log.info("Time taken to send message: {} ms", (System.currentTimeMillis() - startTime));
    }

    @AfterThrowing(pointcut = "execution(* com.vitali.MessageService.sendException())", throwing = "exception")
    public void afterThrowingSend(Exception exception) {
        log.info("Exception occurred while sending message: {}", exception.getMessage());
    }
}
