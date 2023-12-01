package com.luiscarlos.springtest.service.impl;

import com.luiscarlos.springtest.exception.ResourceNotFoundException;
import com.luiscarlos.springtest.model.SuperHero;
import com.luiscarlos.springtest.repository.SuperHeroRepository;
import com.luiscarlos.springtest.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    @Autowired
    SuperHeroRepository superHeroRepository;

    @Override
    public SuperHero findSuperHeroById(long id) {
        Optional<SuperHero> superHeroDB = superHeroRepository.findById(id);

        if (superHeroDB.isPresent()) {
            return superHeroDB.get();
        } else {
            throw new ResourceNotFoundException("No se encontro el superheroe con el id: " + id);
        }
    }

    @Override
    public List<SuperHero> findSuperHeroByNameContain(String name) {
        return this.superHeroRepository.findByNameContaining(name);
    }


    @Override
    public List<SuperHero> findSuperHeroByAge(int age) {
        return this.superHeroRepository.findByAge(age);
    }

    @Override
    public List<SuperHero> findAllSuperHeroes() {
        return this.superHeroRepository.findAll();
    }

    @Override
    public void deleteSuperHeroById(long id) {
        Optional<SuperHero> superHeroDB = this.superHeroRepository.findById(id);

        if (superHeroDB.isPresent()) {
            this.superHeroRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("No se encontro el superheroe con el id: " + id);
        }
    }

    @Override
    public SuperHero saveSuperHero(SuperHero superHero) {
        return this.superHeroRepository.save(superHero);
    }

    @Override
    public SuperHero updateSuperHero(SuperHero superHero) {
        Optional<SuperHero> superHeroDB = superHeroRepository.findById(superHero.getId());

        if (superHeroDB.isPresent()) {
            SuperHero superHeroUpdate = superHeroDB.get();
            superHeroUpdate.setName(superHero.getName());
            superHeroUpdate.setAge(superHero.getAge());
            superHeroRepository.save(superHeroUpdate);
            return superHeroUpdate;

        } else {
            throw new ResourceNotFoundException("No se encontro el superheroe con el id: /" + superHero.getId());
        }
    }


}
