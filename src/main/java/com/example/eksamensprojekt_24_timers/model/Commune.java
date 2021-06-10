package com.example.eksamensprojekt_24_timers.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "communes")
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String code;

    @OneToMany(mappedBy = "commune")
    private List<Parish> parishes;

    public Commune() {
    }

    public Commune(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
