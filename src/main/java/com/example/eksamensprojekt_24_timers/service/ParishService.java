package com.example.eksamensprojekt_24_timers.service;

import com.example.eksamensprojekt_24_timers.model.Parish;

import java.util.List;

public interface ParishService {

    List<Parish> getAllParishes();

    Parish createParish(Parish parish);

    Parish updateParish(Parish parish);

    void deleteParish(Parish parish);

    void save(Parish parish);

    List<Parish> getParishesByCommune(Integer id);
}
