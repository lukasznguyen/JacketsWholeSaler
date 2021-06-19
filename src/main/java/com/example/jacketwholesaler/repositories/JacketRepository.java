package com.example.jacketwholesaler.repositories;

import com.example.jacketwholesaler.models.entities.Jacket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JacketRepository extends JpaRepository<Jacket, Long> {
}
