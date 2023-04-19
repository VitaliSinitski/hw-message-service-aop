package com.vitali;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String message = (String) invocation.getArguments()[0];
        log.info("Message intercepted: {}", message);
        return invocation.proceed();
    }
}