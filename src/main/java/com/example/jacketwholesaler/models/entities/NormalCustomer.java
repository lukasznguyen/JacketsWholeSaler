package com.example.jacketwholesaler.models.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "NORMAL")
public class NormalCustomer extends Customer {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String pesel;

    public NormalCustomer() {
    }

    public NormalCustomer(String email, String phoneNumber, String firstName, String lastName, String pesel) {
        super(email, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
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
}