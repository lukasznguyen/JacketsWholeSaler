package com.example.jacketwholesaler.models.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "MANUAL")
public class ManualEmployee extends Employee {

    private boolean hasForkliftLicense;

    public ManualEmployee() {
    }

    public ManualEmployee(String firstName, String lastName, String pesel, double salary, LocalDate hireDate, boolean hasForkliftLicense) {
        super(firstName, lastName, pesel, salary, hireDate);
        this.hasForkliftLicense = hasForkliftLicense;
    }

    public ManualEmployee(String firstName, String lastName, String pesel, double salary, LocalDate hireDate, Double bonus, boolean hasForkliftLicense) {
        super(firstName, lastName, pesel, salary, hireDate, bonus);
        this.hasForkliftLicense = hasForkliftLicense;
    }

    public boolean hasForkliftLicense() {
        return hasForkliftLicense;
    }

    public void setHasForkliftLicense(boolean hasForkliftLicense) {
        this.hasForkliftLicense = hasForkliftLicense;
    }
}
