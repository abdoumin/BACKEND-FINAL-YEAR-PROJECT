package com.pfa.project.models;


import javax.persistence.*;

@Entity
@Table(name = "staff")
@PrimaryKeyJoinColumn(name = "staff_id")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Staff extends Person {

  public Staff() {
  }

  public Staff(
          String firstName,
          String lastName,
          String username,
          String password,
          Integer Age,
          String gender) {
    super(firstName, lastName, username, password, Age, gender);
  }


}
