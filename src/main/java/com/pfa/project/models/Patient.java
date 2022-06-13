package com.pfa.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "patient_id")
public class Patient extends Person {



  @JsonIgnore
  @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Set<Prescription> prescriptions;

  public Patient() {
  }

  public Patient(
          String firstName,
          String lastName,
          String username,
          String password,
          Integer Age,
          String gender) {
    super(firstName, lastName, username, password, Age, gender);
  }

  public Patient(
          String firstName,
          String lastName,
          String username,
          String password,
          Integer Age,
          String gender,
          String medicalHistory,
          LocalDate dateOfAdmission
  ) {
    super(firstName, lastName, username, password, Age, gender);

  }

  public Set<Prescription> getPrescriptions() {
    return prescriptions;
  }

  public void setPrescriptions(Set<Prescription> prescriptions) {
    this.prescriptions = prescriptions;
  }
}
