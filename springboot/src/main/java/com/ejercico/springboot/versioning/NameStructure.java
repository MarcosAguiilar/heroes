package com.ejercico.springboot.versioning;

public class NameStructure {
    private String name;
    private String surname;

    public NameStructure() {
    }

    public NameStructure(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
