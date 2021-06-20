package com.example.jacketwholesaler.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Packet extends EntityBase {

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "packet_quantityjackets", joinColumns = { @JoinColumn(name = "packet_id") }, inverseJoinColumns = { @JoinColumn(name = "quantityjackets_id") })
    private List<QuantityJacket> quantityJackets = new ArrayList<>();

    public Packet() {
    }

    public List<QuantityJacket> getQuantityJackets() {
        return quantityJackets;
    }

    public void setQuantityJackets(List<QuantityJacket> quantityJackets) {
        this.quantityJackets = quantityJackets;
    }
}
