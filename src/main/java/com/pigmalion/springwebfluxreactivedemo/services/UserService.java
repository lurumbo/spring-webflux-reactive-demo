package com.pigmalion.springwebfluxreactivedemo.services;

import com.pigmalion.springwebfluxreactivedemo.model.User;
import com.pigmalion.springwebfluxreactivedemo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;


@Service
public class UserService {

   @Autowired
   IUserRepository userRepository;

    public Flux<User> getAll () {
        return userRepository.findAll();
    }

    public Mono<User> getById (Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> create (User user) {
       // Fix for non auto-incremental id generated
       Long id = new Random().nextLong();
       return userRepository.save(id, user.getName());
    }

}
