package com.pfa.project.repositories;

import com.pfa.project.models.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Query("SELECT patient FROM Patient patient WHERE patient.username=:username")
    Patient findPatientByUsername(@Param("username") String username);

    @Query("SELECT patient FROM Patient patient WHERE patient.id=:id")
    Patient findPatientById(@Param("id") Integer id);
}
