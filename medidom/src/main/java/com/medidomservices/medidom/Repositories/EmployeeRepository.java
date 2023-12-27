package com.medidomservices.medidom.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medidomservices.medidom.Entity.User.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    Optional<Employee> findByEmail(String email);

    @Query("select e from Employee e where e.specialty=:specialty order by rating desc")
    List<Employee> findBySpecialty(@Param("specialty") String specialty);

}
