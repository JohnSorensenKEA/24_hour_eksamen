package com.example.eksamensprojekt_24_timers.model;

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
}
