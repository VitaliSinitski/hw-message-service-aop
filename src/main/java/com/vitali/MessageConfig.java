package com.vitali;

import lombok.RequiredArgsConstructor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MessageConfig {
    private final MessageInterceptor messageInterceptor;

    @Bean
    public MessageService messageService() {
        ProxyFactory proxyFactory = new ProxyFactory(new MessageServiceImpl());
        proxyFactory.addAdvice(messageInterceptor);
        return (MessageService) proxyFactory.getProxy();
    }
}
