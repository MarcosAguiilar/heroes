package com.ejercico.springboot.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;


//@JsonIgnoreProperties(value = {"password"})
@JsonFilter("UserFilter")
public class UserFiteredDto {

    private int id;
    private String name;
    //@JsonIgnore
    private String password;

    public UserFiteredDto() {
    }

    public UserFiteredDto(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
