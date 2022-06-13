package com.pfa.project.repositories;

import com.pfa.project.models.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
  @Query("SELECT person FROM Person person WHERE person.username=:username")
  Person findPersonByUsername(@Param("username") String username);
}
