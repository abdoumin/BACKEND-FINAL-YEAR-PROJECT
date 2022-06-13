package com.pfa.project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "medication")
public class Medication {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToMany(mappedBy = "medication", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  /*@JsonManagedReference*/
  /*@JsonBackReference*/
  @JsonIgnore
  private List<HeureDePrise> heuredeprise;

  @ManyToOne
  @JsonIgnore
  private Prescription prescription;

  String Date,Name,Frequency,Dosage,Meal,Days,EndDate;

  public Medication() {

  }

  public Medication(String date, String name, String frequency, String dosage, String meal, String days, String endDate) {
    Date = date;
    Name = name;
    Frequency = frequency;
    Dosage = dosage;
    Meal = meal;
    Days = days;
    EndDate = endDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  @JsonIgnore
  public List<HeureDePrise> getHeureDePrise() {
    return heuredeprise;
  }

  public void setHeureDePrise(List<HeureDePrise> heureDePrise) {
    this.heuredeprise = heureDePrise;
  }

  public Prescription getPrescription() {
    return prescription;
  }

  public void setPrescription(Prescription prescription) {
    this.prescription = prescription;
  }

  public String getDate() {
    return Date;
  }

  public void setDate(String date) {
    Date = date;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getFrequency() {
    return Frequency;
  }

  public void setFrequency(String frequency) {
    Frequency = frequency;
  }

  public String getDosage() {
    return Dosage;
  }

  public void setDosage(String dosage) {
    Dosage = dosage;
  }

  public String getMeal() {
    return Meal;
  }

  public void setMeal(String meal) {
    Meal = meal;
  }

  public String getDays() {
    return Days;
  }

  public void setDays(String days) {
    Days = days;
  }

  public String getEndDate() {
    return EndDate;
  }

  public void setEndDate(String endDate) {
    EndDate = endDate;
  }
}
