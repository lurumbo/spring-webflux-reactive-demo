package com.pigmalion.springwebfluxreactivedemo.services;

import com.pigmalion.springwebfluxreactivedemo.model.User;
import com.pigmalion.springwebfluxreactivedemo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public Flux<User> getAll () {
        List<User> users = userRepository.findAll();
        return Flux.fromIterable(users);
    }

    public Mono<User> getById (Long id) {
        User user = userRepository.getOne(id);
        return Mono.just(user);
    }

    public Mono<User> create (User user) {
        User dbUser = userRepository.save(user);
        return Mono.just(dbUser);
    }

}
