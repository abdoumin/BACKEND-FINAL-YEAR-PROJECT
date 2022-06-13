package com.pfa.project.repositories;

import com.pfa.project.models.Doctor;
import com.pfa.project.models.Modele;
import com.pfa.project.models.Patient;
import com.pfa.project.models.Prescription;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface ModeleRepository extends CrudRepository<Modele, Integer> {

    @Query("SELECT modele FROM Modele modele WHERE modele.id=:id")
    Modele findModeleById(@Param("id") Integer id);

}
