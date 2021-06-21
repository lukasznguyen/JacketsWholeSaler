package com.example.jacketwholesaler.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderPacket extends EntityBase {

    @Column
    private int packetQuantity;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Packet packet;

    public OrderPacket() {
    }

    public OrderPacket(int packetQuantity, Order order, Packet packet) {
        this.packetQuantity = packetQuantity;
        this.order = order;
        this.packet = packet;
    }

    public OrderPacket(Order order, Packet packet) {
        this.order = order;
        this.packet = packet;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }
}
