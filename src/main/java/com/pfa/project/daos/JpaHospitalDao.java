package com.pfa.project.daos;

import com.pfa.project.models.*;
import com.pfa.project.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class JpaHospitalDao implements HospitalDao {

  @Autowired private  HeureDePriseRepository heureDePriseRepository;

  @Autowired private JournalRepository journalRepository;

  @Autowired private ModeleRepository modeleRepository;

  @Autowired private PersonRepository personRepository;

  @Autowired private PatientRepository patientRepository;

  @Autowired private DoctorRepository doctorRepository;


  @Autowired private PrescriptionRepository prescriptionRepository;


  @Autowired private StaffRepository staffRepository;

  @Autowired private MedicationRepository medicationRepository;


  @Autowired private AdminStaffRepository adminStaffRepository;


  @Override
  public List<Patient> findAllPatients() {
    return (List<Patient>) patientRepository.findAll();
  }


  @Override
  public Patient createPatient(Patient patient) {
    return patientRepository.save(patient);
  }

  @Override
  public Patient findPatientByUsername(String username) {
    return patientRepository.findPatientByUsername(username);
  }

  @Override
  public Patient findPatientByid(Integer id) {
    return patientRepository.findPatientById(id);
  }



  @Override
  public void deletePatient(String username) {
    patientRepository.delete(patientRepository.findPatientByUsername(username));
  }


  @Override
  public List<Person> findAllPersons() {
    return (List<Person>) personRepository.findAll();
  }

  @Override
  public Person findPersonByUsername(String username) {
    return personRepository.findPersonByUsername(username);
  }

  @Override
  public List<Staff> findAllStaff() {
    return (List<Staff>) staffRepository.findAll();
  }

  @Override
  public List<Medication> findAllMedication() {
    return (List<Medication>) medicationRepository.findAll();
  }

  @Override
  public List<Medication> findMedicationByPrescription(Prescription prescription) {
    return (List<Medication>) prescription.getMedications();
  }


  @Override
  public List<Medication> findMedicationByModel(Modele modele) {
    return (List<Medication>) modele.getPrescription().getMedications();
  }


  @Override
  public void deleteMedication(int id) {
    medicationRepository.delete(medicationRepository.findMedicationById(id));
  }

  @Override
  public List<Prescription> findAllPrescriptions() {
    return (List<Prescription>) prescriptionRepository.findAll();
  }

  @Override
  public List<Prescription> findPrescriptionsByDoctor(Doctor doctor) {
    List<Prescription> prescriptions = (List<Prescription>) prescriptionRepository.findAll();
    List<Prescription> result = new ArrayList<>();

    for (Prescription prescription : prescriptions) {
      if (prescription.getDoctor().getId().equals(doctor.getId())) {
        result.add(prescription);
      }
    }

    return result;
  }

  @Override
  public List<Prescription> findPrescriptionsByPatient(Patient patient) {
    List<Prescription> prescriptions = (List<Prescription>) prescriptionRepository.findAll();
    List<Prescription> result = new ArrayList<>();

    for (Prescription prescription : prescriptions) {
      if (prescription.getPatient().getId().equals(patient.getId())) {
        result.add(prescription);
      }
    }

    return result;
  }

  @Override
  public List<Prescription> findPrescriptionsByDoctorToPatient(Doctor doctor, Patient patient) {
    List<Prescription> prescriptions = (List<Prescription>) prescriptionRepository.findAll();
    List<Prescription> result = new ArrayList<>();

    for (Prescription prescription : prescriptions) {
      if (prescription.getPatient().getId().equals(patient.getId())) {
        if (prescription.getDoctor().getId().equals(doctor.getId())) {
          result.add(prescription);
        }
      }
    }

    return result;
  }

  @Override
  public Prescription findPrescriptionByDoctorToPatientOnDate(
      Doctor doctor, Patient patient, String date) {
    LocalDate presDate = LocalDate.parse(date);
    return prescriptionRepository.findPrescriptionByDoctorAndPatientAndDate(
        doctor, patient, presDate);
  }

  @Override
  public Medication addMedicationToPrescription(Prescription prescription, Medication medication) {
    medication.setPrescription(prescription);
    if (!prescription.getMedications().contains(medication)) {
      prescription.getMedications().add(medication);
    }
    return medicationRepository.save(medication);
  }


  @Override
  public Prescription assignPrescription(
      Doctor doctor, Patient patient, Prescription prescription) {
      LocalDate date = LocalDate.now();
      prescription.setDoctor(doctor);
      prescription.setPatient(patient);
      prescription.setPrescriptionDate(date);
      patient.getPrescriptions().add(prescription);
      doctor.getPrescriptions().add(prescription);
      return prescriptionRepository.save(prescription);

  }

  @Override
  public void deletePrescription(int id) {
    prescriptionRepository.delete(prescriptionRepository.findPrescriptionById(id));
  }


  @Override
  public Doctor createDoctor(Doctor doctor) {
    return doctorRepository.save(doctor);
  }

  @Override
  public List<Doctor> findAllDoctors() {
    return (List<Doctor>) doctorRepository.findAll();
  }

  @Override
  public Doctor findDoctorByUsername(String username) {
    return doctorRepository.findDoctorByUsername(username);
  }

  @Override
  public void deleteDoctor(String username) {
    doctorRepository.delete(doctorRepository.findDoctorByUsername(username));
  }

  @Override
  public AdminStaff createAdminStaff(AdminStaff adminStaff) {
    return adminStaffRepository.save(adminStaff);
  }

  @Override
  public List<AdminStaff> findAllAdminStaffs() {
    return (List<AdminStaff>) adminStaffRepository.findAll();
  }

  @Override
  public AdminStaff findAdminStaffByUsername(String username) {
    return adminStaffRepository.findAdminStaffByUsername(username);
  }

  @Override
  public void deleteAdminStaff(String username) {
    adminStaffRepository.delete(adminStaffRepository.findAdminStaffByUsername(username));
  }

  @Override
  public Prescription findPrescriptionById(Integer id) {
    return prescriptionRepository.findPrescriptionById(id);
  }

  @Override
  public Modele createModele(Prescription prescription, Modele modele) {
    modele.setPrescription(prescription);
    return modeleRepository.save(modele);
  }

  @Override
  public List<Modele> findAllModels() {
    return (List<Modele>) modeleRepository.findAll();
  }

  @Override
  public Modele findModeleById(Integer id) {
    return modeleRepository.findModeleById(id);
  }


  @Override
  public Staff findStaffByUsername(String username) {
    return staffRepository.findStaffByUsername(username);
  }

  //Journal Methods
  @Override
  public Journal createJournal(Medication medication, Journal journal) {
    journal.setMedication(medication);
    return journalRepository.save(journal);


  }

  @Override
  public List<Journal> findJournalByPatient(Patient patient) {
    List<Journal> journals = (List<Journal>) journalRepository.findAll();
    List<Journal> result = new ArrayList<>();

    for (Journal journal : journals) {
      if (journal.getMedication().getPrescription().getPatient().getId().equals(patient.getId())) {
        {
          result.add(journal);
        }
      }
    }
    return result;
  }

  @Override
  public List<Journal> findAllJournal() {
    return (List<Journal>) journalRepository.findAll();
  }

  @Override
  public Medication findMedicationById(Integer id) {
    return medicationRepository.findMedicationById(id);
  }

  @Override
  public List<Journal> findJournalByDateAndPatient(LocalDate date, Patient patient) {
    List<Journal> jour = new ArrayList<Journal>();
    List<Journal> journals =(List<Journal>) journalRepository.findAll();
    System.out.println(journals.get(0));
    for(Journal journal : journals)
    {
      if(journal.getDate().equals(date) && journal.getMedication().getPrescription().getPatient().equals(patient))
      {
          jour.add(journal);
      }
    }
    return jour;
 }

  @Override
  public List<Medication> findMedicationsByPatient(Patient patient) {
    Patient patient1 = patient;
    List<Medication> medications = new ArrayList<>();
    for(Prescription prescription : patient.getPrescriptions())
    {
         medications.addAll(prescription.getMedications());
    }
    return medications;
  }

  @Override
  public HeureDePrise createHeureDePrise(HeureDePrise heureDePrise, Medication medication) {
    heureDePrise.setMedication(medication);
    medication.getHeureDePrise().add(heureDePrise);
    return heureDePriseRepository.save(heureDePrise);
  }

  @Override
  public List<HeureDePrise> findHeureByPatient(Patient patient) {
      Patient patient1 = patient;
      List<HeureDePrise> heureDePrises = new ArrayList<>();
      Set<Prescription> prescriptions = patient1.getPrescriptions();
      for(Prescription prescription : prescriptions )
      {
        for(Medication medication : prescription.getMedications())
        {
          heureDePrises.addAll(medication.getHeureDePrise());
        }
      }
      return heureDePrises;

  }


}
