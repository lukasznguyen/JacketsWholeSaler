package com.example.jacketwholesaler.models.entities;

import com.example.jacketwholesaler.models.enums.Size;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.jacketwholesaler.models.enums.Size.S;

@Entity
public class Packet extends EntityBase {

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "packet_quantityjackets", joinColumns = { @JoinColumn(name = "packet_id") }, inverseJoinColumns = { @JoinColumn(name = "quantityjackets_id") })
    private List<QuantityJacket> quantityJackets = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Carton carton;

    @OneToMany(mappedBy = "packet")
    private List<OrderPacket> orderPackets =  new ArrayList<>();

    public Packet() {
    }

    public List<QuantityJacket> getQuantityJackets() {
        return quantityJackets;
    }

    public void setQuantityJackets(List<QuantityJacket> quantityJackets) {
        this.quantityJackets = quantityJackets;
    }

    public int getTotalJacketQuantity() {
        int result = 0;
        for (QuantityJacket quantityJacket : quantityJackets) {
            result += quantityJacket.getQuantity();
        }
        return result;
    }

    public Size getSmallestSize() {
        Size result = null;

        for (QuantityJacket quantityJacket : quantityJackets) {
            if(result == null) {
                result = quantityJacket.getJacket().getSize();
            } else if(result.getId() > quantityJacket.getJacket().getSize().getId()) {
                result = quantityJacket.getJacket().getSize();
            }
        }
        return result;
    }

    public Size getBiggestSize() {
        Size result = null;

        for (QuantityJacket quantityJacket : quantityJackets) {
            if(result == null) {
                result = quantityJacket.getJacket().getSize();
            } else if(result.getId() < quantityJacket.getJacket().getSize().getId()) {
                result = quantityJacket.getJacket().getSize();
            }
        }
        return result;
    }

    public Carton getCarton() {
        return carton;
    }

    public void setCarton(Carton carton) {
        this.carton = carton;
    }

    public List<OrderPacket> getOrderPackets() {
        return orderPackets;
    }

    public void setOrderPackets(List<OrderPacket> orderPackets) {
        this.orderPackets = orderPackets;
    }
}
