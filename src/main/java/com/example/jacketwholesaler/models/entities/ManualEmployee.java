package com.example.jacketwholesaler.models.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "MANUAL")
public class ManualEmployee extends Employee {

    private boolean hasForkliftLicense;

    @ManyToOne
    private Warehouse warehouse;

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

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
