package com.pfa.project.controllers;

import com.pfa.project.daos.HospitalDao;
import com.pfa.project.models.*;
import com.pfa.project.repositories.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
/*@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")*/
public class AppPresController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HospitalDao hospitalDao;

    @PostMapping("/api/doctor/{docUsername}/patient/{patUsername}/prescription")
    public Prescription createPrescription(
            HttpSession session,
            @PathVariable("docUsername") String docUsername,
            @PathVariable("patUsername") String patUsername,
            @RequestBody Prescription prescription) {
        Prescription newPrescription =
                hospitalDao.assignPrescription(
                        hospitalDao.findDoctorByUsername(docUsername),
                        hospitalDao.findPatientByUsername(patUsername),
                        prescription);
        return newPrescription;
    }

    @PostMapping("/api/doctor/{docUsername}/patient/{patUsername}/{presID}/medication")
    public Medication createMedication(
            HttpSession session,
            @PathVariable("docUsername") String docUsername,
            @PathVariable("patUsername") String patUsername,
            @PathVariable("presID") int presID,
            @RequestBody Medication medication) {

        Doctor doctor = hospitalDao.findDoctorByUsername(docUsername);
        Patient patient = hospitalDao.findPatientByUsername(patUsername);
        Medication newMedication =
                hospitalDao.addMedicationToPrescription(
                        hospitalDao.findPrescriptionById(presID),
                        medication);
        return newMedication;
    }


    @DeleteMapping("/api/prescription/delete/{prescriptionId}")
    public void deletePrescription(@PathVariable("prescriptionId") String prescriptionId) {
        hospitalDao.deletePrescription(Integer.parseInt(prescriptionId));
    }


    @PostMapping("/api/prescription/create/modele/{prescriptionId}")
    public Modele createModele(@PathVariable("prescriptionId") String prescriptionId,
                               @RequestBody Modele modele){
        Prescription prescription = hospitalDao.findPrescriptionById(Integer.valueOf(prescriptionId));
        Modele model = hospitalDao.createModele(prescription,modele);
        return model;

    }

    @GetMapping("/api/models/find/all")
    public List<Modele> findAllModels()
    {
        return hospitalDao.findAllModels();
    }

    @RequestMapping("api/modele/find/medications/{modeleId}")
    public List<Medication> findMedicationsByModele(
            @PathVariable("modeleId") Integer id
    )
    {
        Modele modele = hospitalDao.findModeleById(id);
        return hospitalDao.findMedicationByModel(modele);
    }

    @PostMapping("/api/journal/create/{medicationId}")
    public Journal createJournal(@PathVariable("medicationId") String medicationId , @RequestBody Journal journal)
    {
        Medication medication = hospitalDao.findMedicationById(Integer.valueOf(medicationId));
        Journal journal1 = hospitalDao.createJournal(medication,journal);
        return journal1;
    }

    @RequestMapping("api/journals/patient/{patientId}")
    public List<Journal> findJournalByPatient(
            @PathVariable("patientId") Integer id
    )
    {
        Patient patient = hospitalDao.findPatientByid(id);
        return hospitalDao.findJournalByPatient(patient);
    }

    @RequestMapping("api/journals/{patient}/{date}")
    public List<Journal> findJournalByPatientAndDate(@PathVariable("patient") String patient, @PathVariable("date") String date)
    {
        Patient patient1 = hospitalDao.findPatientByid(Integer.valueOf(patient));
        List<Journal> journals = hospitalDao.findJournalByDateAndPatient(LocalDate.parse(date), patient1);
        return journals;
    }

    @RequestMapping("api/patient/medications/{patientId}")
    public List<Medication> findMedicationsByPatient(@PathVariable("patientId") String patient)
    {
        Patient patient1 = hospitalDao.findPatientByid(Integer.valueOf(patient));
        List<Medication> medications = hospitalDao.findMedicationsByPatient(patient1);
        return medications;
    }

    @PostMapping("api/patient/medication/heure/{medicationId}")
    public HeureDePrise createHeureDePrise(@PathVariable("medicationId") String med,@RequestBody HeureDePrise heureDePrise)
    {
        Medication medication = hospitalDao.findMedicationById(Integer.valueOf(med));
        HeureDePrise heureDePrise1 =  hospitalDao.createHeureDePrise(heureDePrise,medication);
        return  heureDePrise1;
    }

    @RequestMapping("api/patient/heuresdeprise/{patientId}")
    public List<HeureDePrise> findheureByPatient(@PathVariable("patientId") String patient)
    {
        Patient patient1 = hospitalDao.findPatientByid(Integer.valueOf(patient));
        return hospitalDao.findHeureByPatient(patient1);
    }
















}
