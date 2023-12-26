package com.medidomservices.medidom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medidomservices.medidom.Entity.User.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
