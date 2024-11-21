package com.ejercico.springboot.dao;

import com.ejercico.springboot.model.Hero;
import com.ejercico.springboot.model.Power;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("dao")
public class HeroDaoService implements HeroService{

    private static List<Hero> heroes= new ArrayList();

    static {
            heroes.add(new Hero(1,"Tony Stark", "Ironman", new Date()));
            heroes.add(new Hero(2,"Peter Parker", "Spiderman", new Date()));
            heroes.add(new Hero(3,"Bruce Banner", "Hulk", new Date()));
            }

    private static int counter = 3;

    @Override
    public List<Hero> getAllHeroes(){
        return heroes;
    }

    @Override
    public Hero getHeroById(int id){
        Hero hero = null;
        for(Hero h: heroes){
            if(h.getId() == id){
                hero = h;
            }
        }
        return hero;
    }

    @Override
    public Hero addHero(Hero hero){
        hero.setId(++counter);
        heroes.add(hero);
        return hero;
    }

    @Override
    public void deleteHero(int id){
        Iterator<Hero> iterator = heroes.iterator();
        Hero hero = null;
        do{
            hero = iterator.next();
            if(hero.getId() == id){
                iterator.remove();
            }
        }while(iterator.hasNext());

    }

    @Override
    public List<Power> findAllPowersByHeroId(int id) {
        return null;
    }

    @Override
    public Power findPowerById(int heroId, int powerId) {
        return null;
    }

    @Override
    public Power addPower(int heroId, Power power) {
        return null;
    }

    @Override
    public void deletePower(int heroId, int powerId) {

    }


}
