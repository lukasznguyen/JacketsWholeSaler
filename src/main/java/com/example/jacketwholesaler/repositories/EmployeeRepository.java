package com.example.jacketwholesaler.repositories;

import com.example.jacketwholesaler.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
