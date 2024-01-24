package com.medidomservices.medidom.Service;

import com.medidomservices.medidom.Entity.ConsultationRequest;

public interface RequestService {
    
    void save(ConsultationRequest request);

    void validateConsultation(int theId);

    String deleteRequestById(Integer theId);
}
