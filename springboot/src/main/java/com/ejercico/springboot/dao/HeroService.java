package com.ejercico.springboot.dao;

import com.ejercico.springboot.model.Hero;
import com.ejercico.springboot.model.Power;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HeroService{
    List<Hero> getAllHeroes();
    Hero getHeroById(int id);
    Hero addHero(Hero hero);
    void deleteHero(int id);

    List<Power> findAllPowersByHeroId(int id);
    Power findPowerById(int heroId, int powerId);
    Power addPower(int heroId, Power power);
    void deletePower(int heroId, int powerId);
}
