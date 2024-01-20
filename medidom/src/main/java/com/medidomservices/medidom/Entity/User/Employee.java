package com.medidomservices.medidom.Entity.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.medidomservices.medidom.Entity.ConsultationRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Employee extends User{
    
    private int experience;

    private String mailingAddress;

    @Enumerated(EnumType.ORDINAL)
    private Specialty specialty;

    private int rating;

    @OneToMany(mappedBy = "employeeId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ConsultationRequest> requests;

    public Employee(String firstName, String lastName, Date dob, Long phoneNumber, String email, String password,
            Role role, int experience, String mailingAddress, Specialty specialty, int rating) {
        super(firstName, lastName, dob, phoneNumber, email, password, role);
        this.experience = experience;
        this.mailingAddress = mailingAddress;
        this.specialty = specialty;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Employee [firstName: " + super.firstName + ", lastName: " + super.lastName 
        + ", DateOfBirth: " + super.dob + ", phoneNumber: " + super.phoneNumber+ ", email: " + super.email
       + ", password: " + super.password + ", role: " + super.role 
       + ", experience=" + experience + ", mailingAddress=" + mailingAddress + ", specialty: " + specialty + "]";
    }

    public void addRequest(ConsultationRequest request){
        if(requests == null)
        requests = new ArrayList<ConsultationRequest>();

        requests.add(request);

        request.setEmployeeId(this);
    }
}
