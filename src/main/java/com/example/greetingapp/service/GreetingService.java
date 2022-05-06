package com.example.greetingapp.service;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;
import java.util.List;

public interface GreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);

    List<Greeting> getAll();

    List<Greeting> deleteGreetingById(Long id);

    Greeting editGreetingById(long id, String name);

}