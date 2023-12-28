package com.medidomservices.medidom.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medidomservices.medidom.Entity.User.Employee;
import com.medidomservices.medidom.Repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void deleteRequestById(String email,int theId) {
        Employee employee = employeeRepository.findByEmail(email);
        
        employee.getRequests().removeIf(i -> i.getRequest_id() == theId);
            
    }
}
