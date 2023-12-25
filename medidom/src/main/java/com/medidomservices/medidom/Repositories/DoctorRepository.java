package com.medidomservices.medidom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medidomservices.medidom.Entity.User.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
    
}
