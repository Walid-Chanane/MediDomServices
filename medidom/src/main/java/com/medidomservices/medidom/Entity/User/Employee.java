package com.medidomservices.medidom.Entity.User;

import java.sql.Date;

import jakarta.persistence.Entity;
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

    private String specialty;

    private int rating;

    public Employee(String firstName, String lastName, Date dob, Long phoneNumber, String email, String password,
            Role role, int experience, String mailingAddress, String specialty, int rating) {
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

}
