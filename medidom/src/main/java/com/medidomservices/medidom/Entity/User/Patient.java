package com.medidomservices.medidom.Entity.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.medidomservices.medidom.Entity.ConsultationRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends User{
    
    private long socialSecurityNumber;

    private String chronicPathology;

    private String specialMedicalTreatment;

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ConsultationRequest> requests;

    

    public Patient(String firstName, String lastName, Date dob, Long phoneNumber, String email, String pass_word,
            Role role, long socialSecurityNumber, String chronicPathology, String specialMedicalTreatment) {
        super(firstName, lastName, dob, phoneNumber, email, pass_word, role);
        this.socialSecurityNumber = socialSecurityNumber;
        this.chronicPathology = chronicPathology;
        this.specialMedicalTreatment = specialMedicalTreatment;
    }

    @Override
    public String toString() {
        return "Patient [firstName: " + super.firstName + ", lastName: " + super.lastName 
         + ", DateOfBirth: " + super.dob + ", phoneNumber: " + super.phoneNumber+ ", email: " + super.email
        + ", password: " + super.pass_word + ", role: " + super.role
         + ", socialSecurityNumber=" + socialSecurityNumber + ", chronicPathology=" + chronicPathology
                + ", specialMedicalTreatment=" + specialMedicalTreatment + "]";
    }

    public void addRequest(ConsultationRequest request){
        if(requests == null)
        requests = new ArrayList<>();

        requests.add(request);

        request.setUserId(this);
    }
    
}
