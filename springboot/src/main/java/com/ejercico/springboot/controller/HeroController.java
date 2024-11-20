package com.ejercico.springboot.controller;

import com.ejercico.springboot.dao.HeroDaoService;
import com.ejercico.springboot.model.Hero;
import com.ejercico.springboot.model.HeroNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class HeroController {

    @Autowired
    private HeroDaoService heroDaoService;

    @GetMapping("/hero")
    public List<Hero> findAll() {
        return heroDaoService.getAllHeroes();
    }

    @GetMapping("/hero/{id}")
    public Hero findById(@PathVariable int id) {
        Hero result = heroDaoService.getHeroById(id);
        if (result == null) {
            throw new HeroNotFoundException("El heroe con id " + id + " no existe");
        }
        return result;
    }

    @PostMapping("/hero")
    public ResponseEntity<Object> addHero(@RequestBody Hero hero) {
        Hero addHero = heroDaoService.addHero(hero);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addHero.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/hero/{id}")
    public void deleteById(@PathVariable int id) {
        Boolean result = heroDaoService.deleteHero(id);
        if (result == null) {
            throw new HeroNotFoundException("El heroe con id " + id + " no existe");
        }
    }

}
