package com.example.greetingapp.controller;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    private static final String template = "Hello , %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * UC2 Extend reetingController to use Services Layer to get Simple Greeting message ”Hello World”
     * http://localhost:8080/greeting
     * @return : {
     *     "id": 1,
     *     "message": "Hello, world!"
     * }
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name){
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }
}


