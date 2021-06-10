package com.example.eksamensprojekt_24_timers.repository;

import com.example.eksamensprojekt_24_timers.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommuneRepository extends JpaRepository<Commune, Integer> {
    Optional<Commune> getCommuneByCode(String code);
}
