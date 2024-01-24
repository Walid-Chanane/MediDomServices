package com.medidomservices.medidom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medidomservices.medidom.Entity.ConsultationRequest;
import com.medidomservices.medidom.Entity.Report;
import com.medidomservices.medidom.Service.EmployeeService;
import com.medidomservices.medidom.Service.RequestService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RequestService requestService;

    @GetMapping("/requests")
    public List<ConsultationRequest> getEmployeeRequests(@AuthenticationPrincipal UserDetails userDetails){
        return employeeService.findByEmail(userDetails.getUsername()).getRequests();
    }

    @GetMapping("/requests/{theId}")
    public ConsultationRequest getRequestById(@PathVariable int theId, @AuthenticationPrincipal UserDetails userDetails){
        return employeeService.getRequestById(userDetails.getUsername(), theId);
    }

    @PutMapping("/validate/{theId}")
    public void validateConsultation(@PathVariable int theId){
        requestService.validateConsultation(theId);
    }

    @PostMapping("/report/{theId}")
    public void postReport(@RequestBody Report report, @PathVariable int theId, @AuthenticationPrincipal UserDetails userDetails){
        ConsultationRequest request = employeeService.getRequestById(userDetails.getUsername(), theId);
        request.setReport(report);
        requestService.save(request);
    }

    @DeleteMapping("/delete/{theId}")
    public String deleteRequest(@PathVariable Integer theId){
        return requestService.deleteRequestById(theId);
    }

}
