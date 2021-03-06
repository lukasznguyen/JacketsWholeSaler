package com.example.jacketwholesaler.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carton extends EntityBase {

    @OneToMany(mappedBy = "carton", cascade = CascadeType.REMOVE)
    private List<Packet> packet = new ArrayList<>();

    @ManyToOne()
    private Warehouse warehouse;

    public Carton() {
    }

    public List<Packet> getPacket() {
        return packet;
    }

    public void setPacket(List<Packet> packet) {
        this.packet = packet;
    }

    public int getPacketsQuantity() {
        return packet.size();
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
