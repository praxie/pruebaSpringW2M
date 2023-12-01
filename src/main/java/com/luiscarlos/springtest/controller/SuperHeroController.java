package com.luiscarlos.springtest.controller;

import com.luiscarlos.springtest.model.SuperHero;
import com.luiscarlos.springtest.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SuperHeroController {
    @Autowired
    SuperHeroService superHeroService;

    @GetMapping("/superheroes")
    public ResponseEntity<List<SuperHero>> getAllSuperHeroes() {
        return ResponseEntity.ok().body(superHeroService.findAllSuperHeroes());
    }

    @GetMapping("/superheroes/{id}")
    public ResponseEntity<SuperHero> getSuperHeroById(@PathVariable long id) {
        return ResponseEntity.ok().body(superHeroService.findSuperHeroById(id));
    }

    @GetMapping("/superheroes/name/{name}")
    public ResponseEntity<List<SuperHero>> getSuperHeroByNameContain(@PathVariable String name) {
        return ResponseEntity.ok().body(superHeroService.findSuperHeroByNameContain(name));
    }

    @GetMapping("/superheroes/age/{age}")
    public ResponseEntity<List<SuperHero>> getSuperHeroByAge(@PathVariable int age) {
        return ResponseEntity.ok().body(superHeroService.findSuperHeroByAge(age));
    }

    @PostMapping("/superheroes")
    public ResponseEntity<SuperHero> saveSuperHero(@RequestBody SuperHero superHero) {
        return ResponseEntity.ok().body(superHeroService.saveSuperHero(superHero));
    }

    @PutMapping("/superheroes/{id}")
    public ResponseEntity<SuperHero> updateSuperHero(@PathVariable long id, @RequestBody SuperHero superHero) {
        superHero.setId(id);
        return ResponseEntity.ok().body(superHeroService.updateSuperHero(superHero));
    }

    @DeleteMapping("/superheroes/{id}")
    public void deleteSuperHero(@PathVariable long id) {
        superHeroService.deleteSuperHeroById(id);
    }
}
