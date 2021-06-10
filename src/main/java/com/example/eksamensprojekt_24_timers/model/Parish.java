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

    private long infectionPressure; //Smittetryk

    private LocalDate shutDownStartDate; //Start på nedlukning
}
