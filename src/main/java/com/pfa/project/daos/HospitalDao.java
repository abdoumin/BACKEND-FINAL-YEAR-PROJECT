package com.pfa.project.daos;

import com.pfa.project.models.*;


import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public interface HospitalDao {
  // Patient related Methods
  List<Patient> findAllPatients();


  Patient createPatient(Patient patient);

  Patient findPatientByUsername(String username);

  Patient findPatientByid(Integer id);

  void deletePatient(String username);

  // Person Methods
  List<Person> findAllPersons();

  Person findPersonByUsername(String username);

  //Staff Methods
  List<Staff> findAllStaff();

  Staff findStaffByUsername(String username);

  //Medication & Medical Tests Methods
  List<Medication> findAllMedication();


  List<Medication> findMedicationByPrescription(Prescription prescription);

  void deleteMedication(int id);

  /*void deleteMedicalTest(int id);*/

  // Prescription Methods
  List<Prescription> findAllPrescriptions();

  List<Prescription> findPrescriptionsByDoctor(Doctor doctor);

  List<Prescription> findPrescriptionsByPatient(Patient patient);

  List<Prescription> findPrescriptionsByDoctorToPatient(Doctor doctor, Patient patient);

  Prescription findPrescriptionByDoctorToPatientOnDate(Doctor doctor, Patient patient, String date);

  Medication addMedicationToPrescription(Prescription prescription, Medication medication);



  Prescription assignPrescription(Doctor doctor, Patient patient, Prescription prescription);

  void deletePrescription(int id);

  // Appointment Methods

  //Doctor Methods
  Doctor createDoctor(Doctor doctor);

  List<Doctor> findAllDoctors();

  Doctor findDoctorByUsername(String username);

  void deleteDoctor(String username);

  // Admin Staff Methods
  AdminStaff createAdminStaff(AdminStaff adminStaff);

  List<AdminStaff> findAllAdminStaffs();

  AdminStaff findAdminStaffByUsername(String username);

  void deleteAdminStaff(String username);



  Prescription findPrescriptionById(Integer id);

  Modele createModele(Prescription prescription, Modele modele);

  List<Modele> findAllModels();

  Modele findModeleById(Integer id);

  List<Medication> findMedicationByModel(Modele modele);

  Journal createJournal(Medication medication, Journal journal);

  List<Journal> findJournalByPatient(Patient patient);

  List<Journal> findAllJournal();

  Medication findMedicationById(Integer id);

  List<Journal> findJournalByDateAndPatient(LocalDate date, Patient patient);

  List<Medication> findMedicationsByPatient(Patient patient);

  HeureDePrise createHeureDePrise(HeureDePrise heureDePrise,Medication medication);

  List<HeureDePrise> findHeureByPatient(Patient patient);



}
