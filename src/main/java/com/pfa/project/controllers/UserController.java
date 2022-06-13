package com.pfa.project.controllers;

import com.pfa.project.daos.HospitalDao;
import com.pfa.project.models.AdminStaff;
import com.pfa.project.models.Doctor;
import com.pfa.project.models.Patient;
import com.pfa.project.models.User;
import com.pfa.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
/*@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")*/
public class UserController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  HospitalDao hospitalDao;

  @PostMapping("/register")
  public User register(HttpSession session, @RequestBody User user) {
    if (userRepository.findUserByUsername(user.getUsername()) != null) {
      return null;
    } else {
      if (user.getUserType().equals("Patient") && user.getUserKey().equals("abc123")) {
        User newUser = userRepository.save(user);
        session.setAttribute("profile", newUser);
        return newUser;
      } else if (user.getUserType().equals("Doctor") && user.getUserKey().equals("def456")) {
        User newUser = userRepository.save(user);
        session.setAttribute("profile", newUser);
        return newUser;
      } else if (user.getUserType().equals("Admin Staff") && user.getUserKey().equals("ghi789")) {
        User newUser = userRepository.save(user);
        //        user.setPassword("****");
        session.setAttribute("profile", newUser);
        return newUser;
      } else return null;
    }
  }

  @PostMapping("/login")
  public User login(HttpSession session, @RequestBody User user) {
    User profile = userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
    session.setAttribute("profile", profile);
    return profile;
  }

  @PostMapping("/profile")
  public User profile(HttpSession session) {
    User profile = (User) session.getAttribute("profile");
    return profile;
  }

  @PostMapping("/logout")
  public void logout(HttpSession session) {
    session.invalidate();
  }

  @PostMapping("/api/patient/create")
  public Patient createPatient(HttpSession session, @RequestBody Patient patient) {
    Patient newPatient = hospitalDao.createPatient(patient);
    session.setAttribute("patient", newPatient);
    return newPatient;
  }

  @PutMapping("/api/patient/update/{username}")
  public Patient updatePatient(
      HttpSession session,
      @RequestBody Patient updatedPatient,
      @PathVariable("username") String username) {
    Patient prevPatient = hospitalDao.findPatientByUsername(username);
    prevPatient.setFirstName(updatedPatient.getFirstName());
    prevPatient.setLastName(updatedPatient.getLastName());
    prevPatient.setAge(updatedPatient.getAge());
    prevPatient.setGender(updatedPatient.getGender());
    session.setAttribute("patient", updatedPatient);
    return hospitalDao.createPatient(prevPatient);
  }

  @PostMapping("/api/doctor/create")
  public Doctor createDoctor(HttpSession session, @RequestBody Doctor doctor) {
    Doctor newDoctor = hospitalDao.createDoctor(doctor);
    session.setAttribute("doctor", newDoctor);
    return newDoctor;
  }

  @PutMapping("/api/doctor/update/{username}")
  public Doctor updateDoctor(
      HttpSession session,
      @RequestBody Doctor updatedDoctor,
      @PathVariable("username") String username) {
    Doctor prevDoctor = hospitalDao.findDoctorByUsername(username);
    prevDoctor.setFirstName(updatedDoctor.getFirstName());
    prevDoctor.setLastName(updatedDoctor.getLastName());
    prevDoctor.setAge(updatedDoctor.getAge());
    prevDoctor.setGender(updatedDoctor.getGender());
    session.setAttribute("updatedDoctor", updatedDoctor);
    return hospitalDao.createDoctor(prevDoctor);
  }

  @PostMapping("/api/adminStaff/create")
  public AdminStaff createAdminStaff(HttpSession session, @RequestBody AdminStaff adminStaff) {
    AdminStaff newStaff = hospitalDao.createAdminStaff(adminStaff);
    session.setAttribute("admin", newStaff);
    return newStaff;
  }

  @PutMapping("/api/adminStaff/update/{username}")
  public AdminStaff updateAdminStaff(
          HttpSession session,
          @RequestBody AdminStaff adminStaff,
          @PathVariable("username") String username) {
    AdminStaff prevAdmin = hospitalDao.findAdminStaffByUsername(username);
    prevAdmin.setFirstName(adminStaff.getFirstName());
    prevAdmin.setLastName(adminStaff.getLastName());
    prevAdmin.setAge(adminStaff.getAge());
    prevAdmin.setGender(adminStaff.getGender());
    return hospitalDao.createAdminStaff(prevAdmin);
  }




  @DeleteMapping("/api/doctor/delete/{doctorId}")
  public void deleteDoctor(@PathVariable("doctorId") String doctorId) {
    hospitalDao.deleteDoctor(doctorId);
  }

  @DeleteMapping("/api/patient/delete/{patientId}")
  public void deletePatient(@PathVariable("patientId") String patientId) {
    hospitalDao.deletePatient(patientId);
  }


}
