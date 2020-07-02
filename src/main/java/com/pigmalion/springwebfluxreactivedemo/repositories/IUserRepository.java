package com.pigmalion.springwebfluxreactivedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pigmalion.springwebfluxreactivedemo.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IUserRepository extends ReactiveCrudRepository<User, Long> {
}
