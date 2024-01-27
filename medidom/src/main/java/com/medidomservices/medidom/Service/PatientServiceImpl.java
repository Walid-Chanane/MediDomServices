package com.medidomservices.medidom.Service;

import java.sql.Date;
import java.time.LocalDate;
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
    public List<ConsultationRequest> findPatientRequests(String email) {
        List<ConsultationRequest> requests = patientRepository.findByEmail(email).getRequests();
        requests.removeIf(i -> i.getFeedback() != null);
        return requests;
    }

    @Override
    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    @Override
    public ConsultationRequest assignEmployeeToRequest(String email, ConsultationRequest userRequest) {
        userRequest.setPatientId(patientRepository.findByEmail(email));
        
        List<Employee> employeeList = employeeRepository.findBySpecialty(userRequest.getService());
        return findEmployeeForRequest(userRequest, employeeList);
        
    }

    private ConsultationRequest findEmployeeForRequest(ConsultationRequest userRequest, List<Employee> employeeList) {
        LocalDate theDate = userRequest.getRequestDate().toLocalDate();
        Boolean found;
        for (Employee employee : employeeList) {
            found = true;
            for (ConsultationRequest request : employee.getRequests()) { 
                
                if(theDate.isEqual(request.getRequestDate().toLocalDate()) && userRequest.getRequestTime() == request.getRequestTime()){
                    found = false;
                    break;
                }
                
            }
            if(found == true){
                employee.addRequest(userRequest);
                employeeRepository.save(employee);
                return userRequest;
            }
        }
        if(userRequest.getRequestTime() < 3) {
            userRequest.setRequestTime(userRequest.getRequestTime()+1);
            return findEmployeeForRequest(userRequest, employeeList);
        }
        else{
            userRequest.setRequestDate(Date.valueOf(userRequest.getRequestDate().toLocalDate().plusDays(1)));
            userRequest.setRequestTime(1);
            return findEmployeeForRequest(userRequest, employeeList);
        }
    }
   
    @Override
    public ConsultationRequest getRequestById(String email, int theId) {
        Patient patient = patientRepository.findByEmail(email);
        return patient.getRequests().stream().filter(i -> i.getRequest_id() == theId).findFirst().get();
    }

}
