package com.vitali;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MessageAspect {
    private long startTime;

    public void beforeSend() {
        log.info("Before send method is called");
        startTime = System.currentTimeMillis();
    }

    public void afterSend() {
        log.info("After send method is called");
    }

    public void afterReturningSend(Object result) {
        log.info("Message sent successfully: {}", result);
        log.info("Time taken to send message: {} ms", (System.currentTimeMillis() - startTime));
    }

    public void afterThrowingSend(Exception exception) {
        log.info("Exception occurred while sending message: {}", exception.getMessage());
    }
}
