package com.casheep.service;

import org.springframework.stereotype.Service;

@Service
public class TextServiceImpl implements TextService {

    @Override
    public String uppercase(String msg) {
        return (msg != null ? msg : "default").toUpperCase();
    }
}
