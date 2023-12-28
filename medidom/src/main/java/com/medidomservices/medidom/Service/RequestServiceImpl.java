package com.medidomservices.medidom.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medidomservices.medidom.Entity.ConsultationRequest;
import com.medidomservices.medidom.Repositories.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService{

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public void save(ConsultationRequest request) {
        requestRepository.save(request);
    }

    @Override
    public void validateConsultation(int theId) {
        ConsultationRequest request = requestRepository.findById(theId).get();
        request.setDone(true);
        requestRepository.save(request);
    }
    
}
