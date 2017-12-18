package com.casheep.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/")
public class MyController {

    @RequestMapping(path = "status", method = RequestMethod.GET)
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Operational");
    }
}
