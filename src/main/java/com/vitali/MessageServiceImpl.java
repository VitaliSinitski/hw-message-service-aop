package com.vitali;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public void send(String message) {
        log.info("Sending message: {}", message);
    }

    @Override
    public void sendException() throws Exception {
        throw new RuntimeException("Exception occurred in sendException method!");
    }
}

