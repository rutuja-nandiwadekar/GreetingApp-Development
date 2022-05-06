package com.example.greetingapp.service;


import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceimpl implements GreetingService{

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    //UC2 UC3 UC4
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    //UC5
    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    //UC6
    @Override
    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }

    //7
    @Override
    public Greeting editGreetingById(long id, String name) {
        Greeting greeting = greetingRepository.findById(id).get();
        greeting.setMessage(name);
        greetingRepository.save(greeting);
        return greeting;
    }

    //uc8
    @Override
    public List<Greeting> deleteGreetingById(Long id) {
        greetingRepository.deleteById(id);
        return greetingRepository.findAll();
    }
}