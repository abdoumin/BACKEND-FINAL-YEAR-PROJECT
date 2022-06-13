package com.pfa.project.models;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prescriptions")
public class Prescription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  //  @JsonIgnore
  private Patient patient;

  @ManyToOne
//  @JsonIgnore
  private Doctor doctor;

  @OneToMany(mappedBy = "prescription", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private List<Medication> medications;

  private LocalDate prescriptionDate;
  private String refillData;


  public Prescription() {
  }

  public Prescription(
          LocalDate prescriptionDate,
          String refillData
          ) {
    this.prescriptionDate = prescriptionDate;
    this.refillData = refillData;

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public LocalDate getPrescriptionDate() {
    return prescriptionDate;
  }

  public void setPrescriptionDate(LocalDate prescriptionDate) {
    this.prescriptionDate = prescriptionDate;
  }

  public String getRefillData() {
    return refillData;
  }

  public void setRefillData(String refillData) {
    this.refillData = refillData;
  }


  public List<Medication> getMedications() {
    return medications;
  }

  public void setMedications(List<Medication> medications) {
    this.medications = medications;
  }

}
