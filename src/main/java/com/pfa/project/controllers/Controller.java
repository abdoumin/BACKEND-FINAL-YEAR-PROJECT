package com.pfa.project.controllers;

import com.pfa.project.daos.HospitalDao;
import com.pfa.project.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")*/
public class Controller {

  @Autowired private HospitalDao hospitalDao;

  /** Find Alls */
  @GetMapping("api/persons/find/all")
  public List<Person> findAllPersons() {
    return (List<Person>) hospitalDao.findAllPersons();
  }

  @GetMapping("api/patients/find/all")
  public List<Patient> findAllPatients() {
    return (List<Patient>) hospitalDao.findAllPatients();
  }

  @GetMapping("api/doctors/find/all")
  public List<Doctor> findAllDoctors() {
    return (List<Doctor>) hospitalDao.findAllDoctors();
  }

  @GetMapping("api/prescriptions/find/all")
  public List<Prescription> findAllPrescriptions() {
    return (List<Prescription>) hospitalDao.findAllPrescriptions();
  }


  @GetMapping("api/staff/find/all")
  public List<Staff> findAllStaff() {
    return (List<Staff>) hospitalDao.findAllStaff();
  }

  @GetMapping("api/medication/find/all")
  List<Medication> findAllMedication() {
    return (List<Medication>) hospitalDao.findAllMedication();
  }


  @GetMapping("api/adminstaff/find/all")
  List<AdminStaff> findAllAdminStaffs() {
    return (List<AdminStaff>) hospitalDao.findAllAdminStaffs();
  }

  /** Find by username */
  @RequestMapping("api/persons/find/username/{username}")
  public Person findPersonByUsername(@PathVariable("username") String username) {
    return hospitalDao.findPersonByUsername(username);
  }

  @RequestMapping("api/patients/find/username/{username}")
  public Patient findPatientByUsername(@PathVariable("username") String username) {
    return hospitalDao.findPatientByUsername(username);
  }

  @RequestMapping("api/patients/find/username/{id}")
  public Patient findPatientByid(@PathVariable("id") Integer id) {
    return hospitalDao.findPatientByid(id);
  }

  @RequestMapping("api/doctors/find/username/{username}")
  public Doctor findDoctorByUsername(@PathVariable("username") String username) {
    return hospitalDao.findDoctorByUsername(username);
  }

  @RequestMapping("api/adminstaff/find/username/{username}")
  public AdminStaff findAdminStaffByUsername(@PathVariable("username") String username) {
    return hospitalDao.findAdminStaffByUsername(username);
  }


  /** Class specific Many to Many */
  @RequestMapping("api/prescription/find/doctor/{username}")
  public List<Prescription> findPrescriptionsByDoctor(@PathVariable("username") String username) {
    return (List<Prescription>) hospitalDao.findPrescriptionsByDoctor(hospitalDao.findDoctorByUsername(username));
  }

  @RequestMapping("api/prescription/find/patient/{username}")
  public List<Prescription> findPrescriptionsByPatient(@PathVariable("username") String username) {
    return hospitalDao.findPrescriptionsByPatient(hospitalDao.findPatientByUsername(username));
  }

  @RequestMapping("api/prescription/find/doctor-patient/{docusername}/{patusername}")
  public List<Prescription> findPrescriptionsByDoctorToPatient(
      @PathVariable("docusername") String docusername,
      @PathVariable("patusername") String patusername) {
    return hospitalDao.findPrescriptionsByDoctorToPatient(
        hospitalDao.findDoctorByUsername(docusername),
        hospitalDao.findPatientByUsername(patusername));
  }

  @RequestMapping("api/prescription/find/medications/{prescription}")
  public List<Medication> findMedicationsByPrescription(
          @PathVariable("prescription") Integer id
  )
  {
    Prescription prescription = hospitalDao.findPrescriptionById(id);
    return hospitalDao.findMedicationByPrescription(prescription);
  }

}
