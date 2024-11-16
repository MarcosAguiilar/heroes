package com.ejercico.springboot.dao;

import com.ejercico.springboot.model.Hero;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HeroDaoService {

    private static List<Hero> heroes= Arrays.asList(
        new Hero(1,"Tony Stark", "Ironman", new Date()),
        new Hero(2,"Peter Parker", "Spiderman", new Date()),
        new Hero(3,"Bruce Banner", "Hulk", new Date())
            );

    private static int counter = 3;

    public List<Hero> getAllHeroes(){
        return heroes;
    }

    public Hero getHeroById(int id){
        Hero hero = null;
        for(Hero h: heroes){
            if(h.getId() == id){
                hero = h;
            }
        }
        return hero;
    }

    public Hero addHero(Hero hero){
        hero.setId(++counter);
        heroes.add(hero);
        return hero;
    }

    public Boolean deleteHero(int id){
        Iterator<Hero> iterator = heroes.iterator();
        Hero hero = null;
        do{
            hero = iterator.next();
            if(hero.getId() == id){
                iterator.remove();
                return true;
            }
        }while(iterator.hasNext());
        return false;
    }



}
