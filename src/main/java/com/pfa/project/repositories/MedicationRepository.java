package com.pfa.project.repositories;

import com.pfa.project.models.Medication;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Integer> {
  @Query("SELECT medication FROM Medication medication WHERE medication.id=:id")
  Medication findMedicationById(@Param("id") Integer id);
}
