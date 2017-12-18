package com.casheep.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CasheepListener {

    @JmsListener(destination = "casheep1")
    public void receiveMessage(String message) {
        System.out.println(message);
    }
}
