package com.example.eksamensprojekt_24_timers.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "parishes")
public class Parish { //Sogn

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int code; //Sognekode

    private String name; //Navn

    @ManyToOne
    @JoinColumn(name = "commune_id")
    private Commune commune; //Kommune

    private float infectionPressure; //Smittetryk

    private LocalDate shutDownStartDate; //Start på nedlukning

    public Parish() {
    }

    public Parish(int code, String name, Commune commune, float infectionPressure, LocalDate shutDownStartDate) {
        this.code = code;
        this.name = name;
        this.commune = commune;
        this.infectionPressure = infectionPressure;
        this.shutDownStartDate = shutDownStartDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public float getInfectionPressure() {
        return infectionPressure;
    }

    public void setInfectionPressure(float infectionPressure) {
        this.infectionPressure = infectionPressure;
    }

    public LocalDate getShutDownStartDate() {
        return shutDownStartDate;
    }

    public void setShutDownStartDate(LocalDate shutDownStartDate) {
        this.shutDownStartDate = shutDownStartDate;
    }
}
