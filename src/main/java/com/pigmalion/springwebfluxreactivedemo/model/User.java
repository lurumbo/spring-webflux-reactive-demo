package com.pigmalion.springwebfluxreactivedemo.model;


import org.springframework.data.annotation.Id;

import javax.annotation.Generated;

public class User {

    @Id
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
