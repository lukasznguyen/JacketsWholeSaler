package com.example.jacketwholesaler.models.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customer_type",discriminatorType = DiscriminatorType.STRING)
public abstract class Customer extends EntityBase {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
