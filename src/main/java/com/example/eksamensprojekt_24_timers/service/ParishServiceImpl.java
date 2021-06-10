package com.example.eksamensprojekt_24_timers.service;

import com.example.eksamensprojekt_24_timers.model.Parish;
import com.example.eksamensprojekt_24_timers.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParishServiceImpl implements ParishService {

    @Autowired
    ParishRepository parishRepository;

    @Override
    public List<Parish> getAllParishes() {
        return parishRepository.findAll();
    }

    @Override
    public Parish createParish(Parish parish) {
        return parishRepository.save(parish);
    }

    @Override
    public Parish updateParish(Parish parish) {
        return parishRepository.save(parish);
    }

    @Override
    public void deleteParish(Parish parish) {
        parishRepository.delete(parish);
    }

    @Override
    public void save(Parish parish) {
        parishRepository.save(parish);
    }
}
