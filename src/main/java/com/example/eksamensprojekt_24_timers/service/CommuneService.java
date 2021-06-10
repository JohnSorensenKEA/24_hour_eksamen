package com.example.eksamensprojekt_24_timers.service;

import com.example.eksamensprojekt_24_timers.model.Commune;

import java.util.List;
import java.util.Optional;

public interface CommuneService {

    void save(Commune commune);

    Optional<Commune> getCommuneByCode(String code);

    List<Commune> getAllCommunes();
}
