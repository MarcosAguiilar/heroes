package com.ejercico.springboot.controller;

import com.ejercico.springboot.dao.HeroService;
import com.ejercico.springboot.model.Hero;
import com.ejercico.springboot.exception.HeroNotFoundException;
import com.ejercico.springboot.model.Power;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class HeroController {


    @Autowired
    @Qualifier("jpa")
    private HeroService heroService;

    @GetMapping("/hero")
    public List<Hero> findAll() {
        return heroService.getAllHeroes();
    }

    @PostMapping("/hero")
    public ResponseEntity<Object> addHero(@RequestBody @Valid Hero hero) {
        Hero addHero = heroService.addHero(hero);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addHero.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/hero/{id}")
    public Hero findById(@PathVariable int id) {
        Hero result = heroService.getHeroById(id);
        if (result == null) {
            throw new HeroNotFoundException("El heroe con id " + id + " no existe");
        }
        return result;
    }

    @DeleteMapping("/hero/{id}")
    public void deleteById(@PathVariable int id) {
        Hero result = heroService.getHeroById(id);
        if (result == null) {
            throw new HeroNotFoundException("El heroe con id " + id + " no existe");
        }
    }

    @GetMapping("/hero/{heroId}/power")
    public List<Power> findAllPowerByHeroId(@PathVariable int heroId) {
        return heroService.findAllPowersByHeroId(heroId);
    }

    @GetMapping("/hero/{heroId}/power/{powerId}")
    public Power findByPowerById(@PathVariable int heroId, @PathVariable int powerId) {
        return heroService.findPowerById(heroId, powerId);
    }

    @PostMapping("/hero/{heroId}/power")
    public ResponseEntity<Object> addPower(@PathVariable int heroId, @RequestBody @Valid Power power) {
        Power addedPower = heroService.addPower(heroId, power);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{powerId}")
                .buildAndExpand(addedPower.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/hero/{heroId}/power/{powerId}")
    public void deletePowerById(@PathVariable int heroId, @PathVariable int powerId) {
        heroService.deletePower(heroId,powerId);
    }

}
