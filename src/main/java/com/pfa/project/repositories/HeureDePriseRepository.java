package com.pfa.project.repositories;

import com.pfa.project.models.AdminStaff;
import com.pfa.project.models.HeureDePrise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HeureDePriseRepository extends CrudRepository<HeureDePrise, Integer> {
  /*@Query("SELECT AdminStaff FROM AdminStaff AdminStaff WHERE AdminStaff.username=:username")
  AdminStaff findAdminStaffByUsername(@Param("username") String username);*/
}
