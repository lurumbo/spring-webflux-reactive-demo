package com.pigmalion.springwebfluxreactivedemo.controllers;

import com.pigmalion.springwebfluxreactivedemo.model.User;
import com.pigmalion.springwebfluxreactivedemo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public Flux<User> getAll () {
       return userService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<User> getById (@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public String create (@RequestBody User user) {
        Mono<User> dbUser = userService.create(user);
        // Subscription to the publisher
        dbUser.subscribe(u -> logger.info("The user " + u.getName().toUpperCase() + " was created with the id " + u.getId() ));
        return "New user created";
    }

}
