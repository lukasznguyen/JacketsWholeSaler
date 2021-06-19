package com.example.jacketwholesaler.models.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Employee extends EntityBase {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String pesel;

    @Column(nullable = false)
    private double salary;

    @Column(nullable = false)
    private LocalDate hireDate;

    @Column
    private Double bonus;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String pesel, double salary, LocalDate hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Employee(String firstName, String lastName, String pesel, double salary, LocalDate hireDate, Double bonus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.salary = salary;
        this.hireDate = hireDate;
        this.bonus = bonus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
}

