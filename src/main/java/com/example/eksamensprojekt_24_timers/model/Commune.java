package com.example.eksamensprojekt_24_timers.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @JsonBackReference
    @OneToMany(mappedBy = "commune")
    private List<Parish> parishes;

    public Commune() {
    }

    public Commune(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Parish> getParishes() {
        return parishes;
    }

    public void setParishes(List<Parish> parishes) {
        this.parishes = parishes;
    }
}
