package com.medidomservices.medidom.Service;

import com.medidomservices.medidom.Entity.ConsultationRequest;

public interface PatientService {
    
    ConsultationRequest assignEmployeeToRequest(ConsultationRequest request);

    void deleteRequestById(String email, int theId);

}
