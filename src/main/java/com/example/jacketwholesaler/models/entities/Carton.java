package com.example.jacketwholesaler.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carton extends EntityBase {

    @OneToMany(mappedBy = "carton", cascade = { CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST })
    private List<Packet> packet = new ArrayList<>();

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

}
