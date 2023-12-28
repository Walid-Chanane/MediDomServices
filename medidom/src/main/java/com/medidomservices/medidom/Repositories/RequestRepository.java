package com.medidomservices.medidom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medidomservices.medidom.Entity.ConsultationRequest;

public interface RequestRepository extends JpaRepository<ConsultationRequest, Integer>{
    
}
