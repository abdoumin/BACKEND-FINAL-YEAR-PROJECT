package com.pfa.project.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "heuredeprise")
public class HeureDePrise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    /*@JsonIgnore*/
    /*@JsonBackReference*/
    /*@JsonManagedReference*/
    private Medication medication;

    LocalTime heuredeprise;

    public HeureDePrise() {
    }

    public HeureDePrise(LocalTime heuredeprise) {
        this.heuredeprise = heuredeprise;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public LocalTime getHeuredeprise() {
        return heuredeprise;
    }

    public void setHeuredeprise(LocalTime heuredeprise) {
        this.heuredeprise = heuredeprise;
    }
}
