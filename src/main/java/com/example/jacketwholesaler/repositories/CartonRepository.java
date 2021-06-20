package com.example.jacketwholesaler.repositories;

import com.example.jacketwholesaler.models.entities.Carton;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartonRepository extends JpaRepository<Carton, Long> {
}
