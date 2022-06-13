package com.pfa.project.repositories;

import com.pfa.project.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface JournalRepository extends CrudRepository<Journal, Integer> {

    @Query("SELECT journal FROM Journal journal WHERE journal.id=:id")
    Modele findJournalbyId(@Param("id") Integer id);


}
