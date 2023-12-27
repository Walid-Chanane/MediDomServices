package com.medidomservices.medidom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medidomservices.medidom.Entity.ConsultationRequest;
import com.medidomservices.medidom.Entity.User.User;
import com.medidomservices.medidom.Repositories.UserRepository;
import com.medidomservices.medidom.Service.UserService;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    
    @GetMapping("/user")
    public User getPatientRequests(@AuthenticationPrincipal UserDetails userDetails){
        
        return userRepository.findByEmail(userDetails.getUsername());
    }

    @GetMapping("affectation")
    public String getRequestToValidate(@RequestBody ConsultationRequest request){
        
        return userService.assignEmployeeToRequest(request);
    }

}
