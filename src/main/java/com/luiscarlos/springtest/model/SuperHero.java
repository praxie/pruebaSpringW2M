package com.luiscarlos.springtest.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "superhero")
@Data
public class SuperHero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

}
