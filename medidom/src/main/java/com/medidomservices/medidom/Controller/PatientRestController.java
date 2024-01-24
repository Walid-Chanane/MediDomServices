package com.medidomservices.medidom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medidomservices.medidom.Entity.ConsultationRequest;
import com.medidomservices.medidom.Entity.Feedback;
import com.medidomservices.medidom.Service.PatientService;
import com.medidomservices.medidom.Service.RequestService;

@RestController
@RequestMapping("/patient")
public class PatientRestController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private RequestService requestService;

    @GetMapping("/requests")
    public List<ConsultationRequest> getPatientRequests(@AuthenticationPrincipal UserDetails userDetails){
        return patientService.findByEmail(userDetails.getUsername()).getRequests();
    }

    @GetMapping("/requests/{theId}")
    public ConsultationRequest getRequestById(@PathVariable int theId, @AuthenticationPrincipal UserDetails userDetails){
        return patientService.getRequestById(userDetails.getUsername(), theId);
    }

    @PostMapping("/affectation")
    public ConsultationRequest getRequestToValidate(@RequestBody ConsultationRequest request, @AuthenticationPrincipal UserDetails userDetails){
        return patientService.assignEmployeeToRequest(userDetails.getUsername(), request);    
    }

    @PostMapping("/feedback/{theId}")
    public void postFeedback(@RequestBody Feedback feedback, @PathVariable int theId, @AuthenticationPrincipal UserDetails userDetails){
        ConsultationRequest request = patientService.getRequestById(userDetails.getUsername(), theId);
        request.setFeedback(feedback);
        requestService.save(request);
    }

    @DeleteMapping("/delete/{theId}")
    public String deleteRequest(@PathVariable Integer theId){
        return requestService.deleteRequestById(theId);
    }

}
