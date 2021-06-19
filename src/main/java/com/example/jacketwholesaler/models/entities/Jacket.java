package com.example.jacketwholesaler.models.entities;

import com.example.jacketwholesaler.models.enums.Color;
import com.example.jacketwholesaler.models.enums.Size;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Jacket extends EntityBase {

    @Column(nullable = false)
    private long modelNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Size size;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Color color;

    @Column(nullable = false)
    private double price;

    public Jacket() {
    }

    public Jacket(long modelNumber, Size size, Color color, double price) {
        this.modelNumber = modelNumber;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public long getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(long modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
