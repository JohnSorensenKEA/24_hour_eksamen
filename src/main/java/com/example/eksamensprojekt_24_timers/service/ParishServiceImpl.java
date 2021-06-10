package com.example.eksamensprojekt_24_timers.service;

import com.example.eksamensprojekt_24_timers.model.Parish;
import com.example.eksamensprojekt_24_timers.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ParishServiceImpl implements ParishService {

    @Autowired
    ParishRepository parishRepository;

    @Override
    public List<Parish> getAllParishes() {
        List<Parish> parishes = parishRepository.findAll();

        for (Parish p : parishes){
            LocalDate shutDownEndDate = p.getShutDownEndDate();
            if (shutDownEndDate != null){
                if (shutDownEndDate.isBefore(LocalDate.now())){
                    p.setShutDownEndDate(null);
                    p.setShutDownStartDate(null);

                    parishRepository.save(p);
                }
            }
        }

        return parishes;
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

    @Override
    public List<Parish> getParishesByCommune(Integer id) {
        return parishRepository.findAllByCommuneMatches(id);
    }
}
