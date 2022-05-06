package com.example.greetingapp.service;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;


public interface GreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);


}