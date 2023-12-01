package com.luiscarlos.springtest.controller;

import com.luiscarlos.springtest.model.SuperHero;
import com.luiscarlos.springtest.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superheroes")
public class SuperHeroController {
    @Autowired
    SuperHeroService superHeroService;

    @GetMapping()
    public ResponseEntity<List<SuperHero>> getAllSuperHeroes() {
        return ResponseEntity.ok().body(superHeroService.findAllSuperHeroes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuperHero> getSuperHeroById(@PathVariable long id) {
        return ResponseEntity.ok().body(superHeroService.findSuperHeroById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<SuperHero>> getSuperHeroByNameContain(@PathVariable String name) {
        return ResponseEntity.ok().body(superHeroService.findSuperHeroByNameContain(name));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<SuperHero>> getSuperHeroByAge(@PathVariable int age) {
        return ResponseEntity.ok().body(superHeroService.findSuperHeroByAge(age));
    }

    @PostMapping("")
    public ResponseEntity<SuperHero> saveSuperHero(@RequestBody SuperHero superHero) {
        return ResponseEntity.ok().body(superHeroService.saveSuperHero(superHero));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuperHero> updateSuperHero(@PathVariable long id, @RequestBody SuperHero superHero) {
        superHero.setId(id);
        return ResponseEntity.ok().body(superHeroService.updateSuperHero(superHero));
    }

    @DeleteMapping("/{id}")
    public void deleteSuperHero(@PathVariable long id) {
        superHeroService.deleteSuperHeroById(id);
    }
}
