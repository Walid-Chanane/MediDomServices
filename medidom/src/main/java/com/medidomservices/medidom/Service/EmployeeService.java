package com.medidomservices.medidom.Service;

import java.util.List;

import com.medidomservices.medidom.Entity.ConsultationRequest;
import com.medidomservices.medidom.Entity.User.Employee;

public interface EmployeeService {

    Employee findByEmail(String email);

    List<ConsultationRequest> findEmployeeRequests(String email);
    
    ConsultationRequest getRequestById(String email, int theId);
}
