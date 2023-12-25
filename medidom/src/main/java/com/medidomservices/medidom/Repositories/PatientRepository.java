package com.medidomservices.medidom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medidomservices.medidom.Entity.User.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{
    
}
