package com.ejercico.springboot.versioning;

public class UserVersionV2 {

    private NameStructure name;

    public UserVersionV2() {
    }

    public UserVersionV2(NameStructure name) {
        this.name = name;
    }

    public NameStructure getName() {
        return name;
    }

    public void setName(NameStructure name) {
        this.name = name;
    }
}
