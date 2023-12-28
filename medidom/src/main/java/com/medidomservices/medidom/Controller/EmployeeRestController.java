package com.medidomservices.medidom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medidomservices.medidom.Entity.ConsultationRequest;
import com.medidomservices.medidom.Repositories.EmployeeRepository;
import com.medidomservices.medidom.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/requests")
    public List<ConsultationRequest> getRequests(@AuthenticationPrincipal UserDetails userDetails){
        return employeeRepository.findByEmail(userDetails.getUsername()).getRequests();
    }

    @DeleteMapping("/delete/{theId}")
    public void cancelRequest(@PathVariable int theId, @AuthenticationPrincipal UserDetails userDetails){
        employeeService.deleteRequestById(userDetails.getUsername(), theId);
    }
}
