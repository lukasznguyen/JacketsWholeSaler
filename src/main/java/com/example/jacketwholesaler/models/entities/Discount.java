package com.example.jacketwholesaler.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Discount extends EntityBase {

    @Column(nullable = false)
    private int value;

    @Column(nullable = false)
    private int minimalPurchaseValue;

    @ManyToOne
    private Order order;

    public Discount() {
    }

    public Discount(int value, int minimalPurchaseValue) {
        this.value = value;
        this.minimalPurchaseValue = minimalPurchaseValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMinimalPurchaseValue() {
        return minimalPurchaseValue;
    }

    public void setMinimalPurchaseValue(int minimalPurchaseValue) {
        this.minimalPurchaseValue = minimalPurchaseValue;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
