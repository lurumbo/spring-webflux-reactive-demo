package com.pigmalion.springwebfluxreactivedemo.repositories;

import com.pigmalion.springwebfluxreactivedemo.model.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserRepository extends ReactiveCrudRepository<User, Long> {

    @Query("select * from users")
    Flux<User> findAll();

    @Query("select id, name from users u where u.id = :id")
    Mono<User> findById(Long id);

    @Query("INSERT INTO users (id, name) values (:id, :name)")
    Mono<User> save(Long id, String name);

}
