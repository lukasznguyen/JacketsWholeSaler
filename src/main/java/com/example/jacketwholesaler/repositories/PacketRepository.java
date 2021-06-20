package com.example.jacketwholesaler.repositories;

import com.example.jacketwholesaler.models.entities.Packet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacketRepository extends JpaRepository<Packet, Long> {
}
