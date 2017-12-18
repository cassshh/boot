package com.casheep.controller;

import com.casheep.model.User;
import com.casheep.service.TextService;
import com.casheep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/")
public class MyController {

    private TextService textService;
    private UserService userService;
    private JmsTemplate template;

    public MyController(@Autowired TextService textService, @Qualifier("userServiceImpl") @Autowired UserService userService, JmsTemplate template) {
        this.textService = textService;
        this.userService = userService;
        this.template = template;
    }

    @RequestMapping(path = "status", method = RequestMethod.GET)
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Operational");
    }

    @RequestMapping(path = "echo", method = RequestMethod.GET)
    public ResponseEntity<String> echo(@RequestParam(required = false) String msg) {
        return ResponseEntity.ok(textService.uppercase(msg));
    }

    @RequestMapping(path = "users/init", method = RequestMethod.POST)
    public ResponseEntity createData() {
        userService.createData();
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "users/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserByName(@PathVariable String name) {
        List<User> users = userService.getUserByName(name);
        users.forEach(user -> template.convertAndSend("casheep1", user.getEmail()));
        return ResponseEntity.ok(users);
    }

}
