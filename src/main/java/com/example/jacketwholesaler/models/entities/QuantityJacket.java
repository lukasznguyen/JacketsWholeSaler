package com.example.jacketwholesaler.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class QuantityJacket extends EntityBase {

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    private Jacket jacket;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "packet_quantityjackets", joinColumns = { @JoinColumn(name = "quantityjackets_id") }, inverseJoinColumns = { @JoinColumn(name = "packet_id") })
    private List<Packet> packets = new ArrayList<>();

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
