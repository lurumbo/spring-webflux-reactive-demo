package com.pigmalion.springwebfluxreactivedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pigmalion.springwebfluxreactivedemo.model.User;


public interface IUserRepository extends JpaRepository<User, Long> {
}
