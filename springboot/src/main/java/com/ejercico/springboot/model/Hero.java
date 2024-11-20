package com.ejercico.springboot.model;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class Hero {

    private int id;
    @Size(min=3, message = "El tamaño debe ser mayor que 2")
    private String name;
    private String heroName;
    @Past
    private Date birthday;


    public Hero() {
    }

    public Hero(int id, String name, String heroName, Date birthday) {
        this.id = id;
        this.name = name;
        this.heroName = heroName;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
