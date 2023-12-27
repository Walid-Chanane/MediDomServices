package com.medidomservices.medidom.Entity.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.medidomservices.medidom.Entity.ConsultationRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Patient extends User{
    
    private long socialSecurityNumber;

    private String chronicPathology;

    private String specialMedicalTreatment;

    @OneToMany(mappedBy = "patientId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ConsultationRequest> requests;
    

    public Patient(String firstName, String lastName, Date dob, Long phoneNumber, String email, String password,
            Role role, long socialSecurityNumber, String chronicPathology, String specialMedicalTreatment) {
        super(firstName, lastName, dob, phoneNumber, email, password, role);
        this.socialSecurityNumber = socialSecurityNumber;
        this.chronicPathology = chronicPathology;
        this.specialMedicalTreatment = specialMedicalTreatment;
    }

    @Override
    public String toString() {
        return "Patient [firstName: " + super.firstName + ", lastName: " + super.lastName 
         + ", DateOfBirth: " + super.dob + ", phoneNumber: " + super.phoneNumber+ ", email: " + super.email
        + ", password: " + super.password + ", role: " + super.role
         + ", socialSecurityNumber=" + socialSecurityNumber + ", chronicPathology=" + chronicPathology
                + ", specialMedicalTreatment=" + specialMedicalTreatment + "]";
    }

    public void addRequest(ConsultationRequest request){
        if(requests == null)
        requests = new ArrayList<>();

        requests.add(request);

        request.setPatientId(this);
    }
    
}
