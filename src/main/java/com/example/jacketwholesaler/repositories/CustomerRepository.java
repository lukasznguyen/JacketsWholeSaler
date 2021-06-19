package com.example.jacketwholesaler.repositories;

import com.example.jacketwholesaler.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
