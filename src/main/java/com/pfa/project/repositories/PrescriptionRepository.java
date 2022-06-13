package com.pfa.project.repositories;

import com.pfa.project.models.Doctor;
import com.pfa.project.models.Patient;
import com.pfa.project.models.Prescription;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface PrescriptionRepository extends CrudRepository<Prescription, Integer> {
  @Query("SELECT prescription FROM Prescription prescription WHERE prescription.doctor=:doctor AND prescription.patient=:patient AND prescription.prescriptionDate=:date")
  Prescription findPrescriptionByDoctorAndPatientAndDate(@Param("doctor") Doctor doctor, @Param("patient") Patient patient, @Param("date") LocalDate date);

  @Query("SELECT prescription FROM Prescription prescription WHERE prescription.id=:id")
  Prescription findPrescriptionById(@Param("id") Integer id);
}
