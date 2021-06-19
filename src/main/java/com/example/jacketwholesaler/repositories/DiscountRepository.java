package com.example.jacketwholesaler.repositories;

import com.example.jacketwholesaler.models.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

}
