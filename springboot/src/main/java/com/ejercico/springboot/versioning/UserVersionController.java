package com.ejercico.springboot.versioning;

import org.springframework.web.bind.annotation.GetMapping;

public class UserVersionController {

    @GetMapping("/v1/userversioning")
    public UserVersionV1 getuserVersionV1(){
        return new UserVersionV1("nombre");
    }

    @GetMapping("/v2/userVersioning")
    public UserVersionV2 getuserVersionV2(){
        return new UserVersionV2(new NameStructure("nombre","apellido"));

    }

    //HEADER

    @GetMapping(value = "/userVersioning/hader", headers = "X-API-VERSION=1")
    public UserVersionV1 getuserVersionV1Hader(){
        return new UserVersionV1("nombre");
    }

    @GetMapping(value = "/userVersioning/hader", headers = "X-API-VERSION=2")
    public UserVersionV2 getuserVersionV2Hader(){
        return new UserVersionV2(new NameStructure("nombre", "apellido"));
    }

    //PRODUCERS

    @GetMapping(value = "/userversioning/produces", produces = "application/vnd.company.app-v1+json")
    public UserVersionV1 getuserVersionV1Produces(){
        return new UserVersionV1("nombre");
    }

    @GetMapping(value = "/userversioning/produces", produces = "application/vnd.company.app-v2+json")
    public UserVersionV2 getuserVersionV2Produces(){
        return new UserVersionV2(new NameStructure("nombre", "apellido"));
    }
}
