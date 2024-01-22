package com.medidomservices.medidom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.medidomservices.medidom.Entity.User.Employee;
import com.medidomservices.medidom.Entity.User.Patient;
import com.medidomservices.medidom.Entity.User.User;
import com.medidomservices.medidom.Repositories.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLogin(Model theModel){
        return "index.html";
    }

    @GetMapping("/home")
    public String redirectUser(@AuthenticationPrincipal UserDetails userDetails){
        User user = userRepository.findByEmail(userDetails.getUsername());
        if(user instanceof Patient) return "patientInterface.html";
        if(user instanceof Employee) return "employeeInterface.html";
        return null;
    }
}
