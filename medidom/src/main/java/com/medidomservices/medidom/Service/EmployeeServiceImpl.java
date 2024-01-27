package com.medidomservices.medidom.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medidomservices.medidom.Entity.ConsultationRequest;
import com.medidomservices.medidom.Entity.User.Employee;
import com.medidomservices.medidom.Repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public List<ConsultationRequest> findEmployeeRequests(String email) {
        List<ConsultationRequest> requests = employeeRepository.findByEmail(email).getRequests();
        requests.removeIf(i -> i.getReport() != null);
        return requests;
    }

    @Override
        public Employee findByEmail(String email) {
            return employeeRepository.findByEmail(email);
        }

    @Override
    public ConsultationRequest getRequestById(String email, int theId) {
        Employee employee = employeeRepository.findByEmail(email);
        return employee.getRequests().stream().filter(i -> i.getRequest_id() == theId).findFirst().get();
    }

}
