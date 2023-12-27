package com.medidomservices.medidom.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medidomservices.medidom.Entity.ConsultationRequest;
import com.medidomservices.medidom.Entity.User.Employee;
import com.medidomservices.medidom.Repositories.EmployeeRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String assignEmployeeToRequest(ConsultationRequest userRequest) {
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
                return "success";
            }
        }
        return "false";
    }
}
