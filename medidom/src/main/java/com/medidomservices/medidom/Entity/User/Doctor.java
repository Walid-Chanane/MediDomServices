package com.medidomservices.medidom.Entity.User;

import java.sql.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor extends User{
    
    private int experience;

    private String mailingAddress;

    private int rating;

    public Doctor(String firstName, String lastName, Date dob, Long phoneNumber, String email, String pass_word,
            Role role, int experience, String mailingAddress, int rating) {
        super(firstName, lastName, dob, phoneNumber, email, pass_word, role);
        this.experience = experience;
        this.mailingAddress = mailingAddress;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Doctor [firstName: " + super.firstName + ", lastName: " + super.lastName 
        + ", DateOfBirth: " + super.dob + ", phoneNumber: " + super.phoneNumber+ ", email: " + super.email
       + ", password: " + super.pass_word + ", role: " + super.role 
       + ", experience=" + experience + ", mailingAddress=" + mailingAddress + "]";
    }

}
