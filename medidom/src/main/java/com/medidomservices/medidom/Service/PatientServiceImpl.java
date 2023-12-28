package com.medidomservices.medidom.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medidomservices.medidom.Entity.ConsultationRequest;
import com.medidomservices.medidom.Entity.User.Employee;
import com.medidomservices.medidom.Entity.User.Patient;
import com.medidomservices.medidom.Repositories.EmployeeRepository;
import com.medidomservices.medidom.Repositories.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ConsultationRequest assignEmployeeToRequest(ConsultationRequest userRequest) {
        List<Employee> employeeList = employeeRepository.findBySpecialty("first");
        System.out.println(employeeList);
        int i;
        for (Employee employee : employeeList) {
            i=0;
            for (ConsultationRequest request : employee.getRequests()) { 
                long date1 = request.getRequestDate().getTime();
                String date21 = userRequest.getRequestDate().toString();
                Date date22 = Date.valueOf(date21);
                long date2 = date22.getTime();
                System.out.println(date1);
                System.out.println(date2);
                if(date1 == date2){
                    i++;
                }
            }
            if(i < 3){
                System.out.println(i);
                employee.addRequest(userRequest);
                employeeRepository.save(employee);
                userRequest.setEmployeeId(employee);
                return userRequest;
            }
        }
        return null;
    }

    @Override
    public void deleteRequestById(String email,int theId) {
        Patient patient = patientRepository.findByEmail(email);
        
        patient.getRequests().removeIf(i -> i.getRequest_id() == theId);
            
    }

}
