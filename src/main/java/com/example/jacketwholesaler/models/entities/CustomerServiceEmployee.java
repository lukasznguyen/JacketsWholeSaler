package com.example.jacketwholesaler.models.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "CUSTOMER_SERVICE")
public class CustomerServiceEmployee extends Employee {

    @ElementCollection
    private List<String> languages;

    public CustomerServiceEmployee() {
        languages = new ArrayList<>();
    }

    public CustomerServiceEmployee(String firstName, String lastName, String pesel, double salary, LocalDate hireDate, List<String> languages) {
        super(firstName, lastName, pesel, salary, hireDate);
        this.languages = languages;
    }

    public CustomerServiceEmployee(String firstName, String lastName, String pesel, double salary, LocalDate hireDate, Double bonus, List<String> languages) {
        super(firstName, lastName, pesel, salary, hireDate, bonus);
        this.languages = languages;
    }
}
