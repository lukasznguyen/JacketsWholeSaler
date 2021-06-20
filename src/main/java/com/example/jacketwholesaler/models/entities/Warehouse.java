package com.example.jacketwholesaler.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Warehouse extends EntityBase {

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private int streetNumber;

    @Column
    private Integer apartmentNumber;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "warehouse",  cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST })
    private List<Carton> cartons = new ArrayList<>();

    public Warehouse() {
    }

    public Warehouse(String streetName, int streetNumber, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
    }

    public Warehouse(String streetName, int streetNumber, Integer apartmentNumber, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Carton> getCartons() {
        return cartons;
    }

    public void setCartons(List<Carton> cartons) {
        this.cartons = cartons;
    }
}
