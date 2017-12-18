package com.casheep.controller;

import com.casheep.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/")
public class MyController {

    @Autowired
    private TextService textService;

    @RequestMapping(path = "status", method = RequestMethod.GET)
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Operational");
    }

    @RequestMapping(path = "echo", method = RequestMethod.GET)
    public ResponseEntity<String> echo(@RequestParam(required = false) String msg) {
        return ResponseEntity.ok(textService.uppercase(msg));
    }

}
