package com.luiscarlos.springtest.service;

import com.luiscarlos.springtest.model.SuperHero;

import java.util.List;

public interface SuperHeroService {
    SuperHero findSuperHeroById(long id);

    List<SuperHero> findSuperHeroByNameContain(String name);

    List<SuperHero> findSuperHeroByAge(int age);

    List<SuperHero> findAllSuperHeroes();

    void deleteSuperHeroById(long id);

    SuperHero saveSuperHero(SuperHero superHero);

    SuperHero updateSuperHero(SuperHero superHero);


}
