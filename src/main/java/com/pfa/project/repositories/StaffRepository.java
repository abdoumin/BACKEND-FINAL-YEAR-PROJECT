package com.pfa.project.repositories;

import com.pfa.project.models.Staff;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Integer> {
  @Query("SELECT staff FROM Staff staff WHERE staff.username=:username")
  Staff findStaffByUsername(@Param("username") String username);
}
