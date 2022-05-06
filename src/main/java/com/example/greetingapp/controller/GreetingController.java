package com.example.greetingapp.controller;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    private static final String template = "Hello , %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * UC2
     * @Purpose: Extend reetingController to use Services Layer to get Simple Greeting message ”Hello World”
     * @URL: http://localhost:8080/greeting
     * @Output: {
     *     "id": 1,
     *     "message": "Hello, world!"
     * }
     *
     * UC3
     * @Purpose: Ability for the Greeting App to give Greeting message with
     * 1. User First Name and Last Name or
     * 2. With just First Name or Last Name based on User attributes provides or
     * 3. Just Hello World.
     * @URL: http://localhost:8080/greeting?name=rutuja&name=nandiwadekar
     * @Output:{
     *     "id": 3,
     *     "message": "Hello, rutuja,nandiwadekar!"
     * }
     *
     * UC4
     * @Purpose: Ability for the Greeting App to save the Greeting Message in the Repository
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name){
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    /**
     * UC5
     * @Purpose: Ability for the Greeting App to find a Greeting Message by Id in the Repository
     * @URL: http://localhost:8080/path/3
     * @Output: {
     *     "id": 3,
     *     "message": "Hello, world!"
     * }
     */
    @GetMapping("/path/{id}")
    public Greeting getElementById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }

    /**
     * UC6
     * @Purpose: Ability for the Greeting App to List all the Greeting Messages in the Repository
     * @URL: http://localhost:8080/all
     * @Output: [{
     *         "id": 1,
     *         "message": "Hello, world!"
     *     },
     *     {
     *         "id": 2,
     *         "message": "Hello, rutuja!"
     *     }]
     */
    @GetMapping("/all")
    public List<Greeting> getAll(){
        return greetingService.getAll();
    }

    /**
     * UC7
     * @Purpose: Ability for the Greeting App to Edit a Greeting Messages in the Repository
     * @URL: http://localhost:8080/edit/1?name=ritzyyyyy
     * @Output: Edit message at position Id
     */
    @PutMapping("/edit/{id}")
    public Greeting editGreetingById(@PathVariable long id, @RequestParam String name){
        return greetingService.editGreetingById(id, name);
    }

    /**
     * UC8
     * @Purpose: Ability for the Greeting App to delete a Greeting Messages in the Repository
     * @URL: http://localhost:8080/delete/3
     * @Output: Delete's message at position Id 3
     */
    @DeleteMapping("/delete/{id}")
    public List<Greeting> deleteGreetingById(@PathVariable Long id){
        return greetingService.deleteGreetingById(id);
    }


}


