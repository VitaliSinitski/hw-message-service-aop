package com.vitali;

public interface MessageService {
    void send(String message);
    void sendException() throws Exception;
}
