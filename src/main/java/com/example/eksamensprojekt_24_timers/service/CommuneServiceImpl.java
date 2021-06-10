package com.example.eksamensprojekt_24_timers.service;

import com.example.eksamensprojekt_24_timers.model.Commune;
import com.example.eksamensprojekt_24_timers.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommuneServiceImpl implements CommuneService{

    @Autowired
    CommuneRepository communeRepository;

    @Override
    public void save(Commune commune) {
        communeRepository.save(commune);
    }

    @Override
    public Optional<Commune> getCommuneByCode(String code) {
        return communeRepository.getCommuneByCode(code);
    }

    @Override
    public List<Commune> getAllCommunes() {
        return communeRepository.findAll();
    }
}
