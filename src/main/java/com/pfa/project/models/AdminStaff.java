package com.pfa.project.models;


import javax.persistence.Entity;

@Entity
public class AdminStaff extends Staff {/*
  private String jobTitle;
  private String jobDescription;*/

  public AdminStaff() {
    super();
  }

  public AdminStaff(String firstName, String lastName,
                    String username, String password, Integer Age,
                    String gender) {
    super(firstName, lastName, username, password, Age, gender);
  }

/*public AdminStaff(String firstName, String lastName, String username, String password,
                    LocalDate dateOfBirth, String gender, String status, Department dept, LocalDate joiningDate,
                    String jobTitle, String jobDescription) {
    super(firstName, lastName, username, password, dateOfBirth, gender, status, dept, joiningDate);
    this.jobTitle = jobTitle;
    this.jobDescription = jobDescription;
  }*/



}
