package com.example.jacketwholesaler.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Warehouse extends EntityBase {

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private int streetNumber;

    @Column
    private Integer apartmentNumber;

    public Warehouse() {
    }

    public Warehouse(String streetName, int streetNumber) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public Warehouse(String streetName, int streetNumber, Integer apartmentNumber) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
