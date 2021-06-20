package com.example.jacketwholesaler.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class QuantityJacket extends EntityBase {

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    private Jacket jacket;

    public QuantityJacket() {
    }

    public QuantityJacket(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Jacket getJacket() {
        return jacket;
    }

    public void setJacket(Jacket jacket) {
        this.jacket = jacket;
    }
}
