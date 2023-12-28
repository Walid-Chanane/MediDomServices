package com.medidomservices.medidom.Service;

import java.util.List;

import com.medidomservices.medidom.Entity.ConsultationRequest;
import com.medidomservices.medidom.Entity.User.Patient;

public interface PatientService {

    Patient findByEmail(String email);

    List<ConsultationRequest> findPatientRequests(String email);
    
    ConsultationRequest getRequestById(String email,int theId);

    ConsultationRequest assignEmployeeToRequest(String email, ConsultationRequest request);

    void deleteRequestById(String email, int theId);

}
