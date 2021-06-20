package com.example.jacketwholesaler.repositories;

import com.example.jacketwholesaler.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
