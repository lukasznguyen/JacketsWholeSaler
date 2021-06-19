package com.example.jacketwholesaler.models.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "COMPANY")
public class Company extends Customer {

    @Column
    private String companyName;

    @Column
    private String nip;

    public Company() {
    }

    public Company(String email, String phoneNumber, String companyName, String nip) {
        super(email, phoneNumber);
        this.companyName = companyName;
        this.nip = nip;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}