package com.example.eksamensprojekt_24_timers.repository;

import com.example.eksamensprojekt_24_timers.model.Parish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParishRepository extends JpaRepository<Parish, Integer> {

    @Query("SELECT p FROM Parish p WHERE p.commune.id = ?1")
    List<Parish> findAllByCommuneMatches(Integer id);
}
