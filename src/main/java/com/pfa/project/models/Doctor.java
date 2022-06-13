package com.pfa.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor extends Staff {

  @JsonIgnore
  @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Set<Prescription> prescriptions;

  private String email;


  public Doctor() {

  }

  public Doctor(String firstName, String lastName, String username, String password,
                Integer Age, String gender,String email) {
    super(firstName, lastName, username, password, Age, gender);
    this.email = email;
  }

  public Set<Prescription> getPrescriptions() {
    return prescriptions;
  }

  public void setPrescriptions(Set<Prescription> prescriptions) {
    this.prescriptions = prescriptions;
  }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
