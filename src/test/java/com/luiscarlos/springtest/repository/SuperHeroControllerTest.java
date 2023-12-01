package com.luiscarlos.springtest.repository;

import com.luiscarlos.springtest.model.SuperHero;
import com.luiscarlos.springtest.service.impl.SuperHeroServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class SuperHeroControllerTest {

    @InjectMocks
    private SuperHeroServiceImpl superHeroService;
    @Mock
    private SuperHeroRepository superHeroRepository;

    public SuperHero createSuperHero() {
        SuperHero superHero = new SuperHero();
        superHero.setName("Superman");
        superHero.setAge(30);
        return superHero;
    }

    @Test
    public void findSuperHeroById() {
        SuperHero superHero = createSuperHero();
        when(superHeroRepository.findById(1L)).thenReturn(Optional.of(superHero));

        SuperHero responseEntity = superHeroService.findSuperHeroById(1);

        assertEquals(superHero, responseEntity);
    }


    @Test
    public void findSuperHeroByNameContain() {
        SuperHero superHero = createSuperHero();
        when(superHeroRepository.findByNameContaining("Superman")).thenReturn(List.of(superHero));

        List<SuperHero> responseEntity = superHeroService.findSuperHeroByNameContain("Superman");

        assertEquals(superHero, responseEntity.get(0));
    }

    @Test
    public void findSuperHeroByAge() {
        SuperHero superHero = createSuperHero();
        when(superHeroRepository.findByAge(30)).thenReturn(List.of(superHero));

        List<SuperHero> responseEntity = superHeroService.findSuperHeroByAge(30);

        assertEquals(superHero, responseEntity.get(0));
    }

    @Test
    public void findAllSuperHeroes() {
        SuperHero superHero = createSuperHero();

        SuperHero superHero2 = new SuperHero();
        superHero.setName("Spiderman");
        superHero.setAge(24);

        List<SuperHero> superHeroList = List.of(superHero, superHero2);
        when(superHeroRepository.findAll()).thenReturn(superHeroList);

        List<SuperHero> responseEntity = superHeroService.findAllSuperHeroes();

        assertEquals(superHeroList, responseEntity);
    }

    @Test
    public void deleteSuperHeroById() {
        SuperHero superHero = createSuperHero();

        when(superHeroRepository.findById(1L)).thenReturn(Optional.of(superHero));

        superHeroService.deleteSuperHeroById(1);

        verify(superHeroRepository, times(1)).deleteById(1L);

    }

    @Test
    public void saveSuperHero() {
        SuperHero superHero = createSuperHero();

        superHeroService.saveSuperHero(superHero);

        verify(superHeroRepository, times(1)).save(superHero);

    }

    @Test
    public void updateSuperHero() {
        SuperHero superHero = createSuperHero();

        superHero.setId(1);
        when(superHeroRepository.findById(1L)).thenReturn(Optional.of(superHero));

        SuperHero responseEntity = superHeroService.updateSuperHero(superHero);

        assertThat(responseEntity).isEqualTo(superHero);
    }
}
