package com.example.jacketwholesaler.models.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    public long getId() {
        return id;
    }
}
