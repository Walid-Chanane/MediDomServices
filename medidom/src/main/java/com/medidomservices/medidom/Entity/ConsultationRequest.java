package com.medidomservices.medidom.Entity;

import java.sql.Date;

import com.medidomservices.medidom.Entity.User.Employee;
import com.medidomservices.medidom.Entity.User.Patient;
import com.medidomservices.medidom.Entity.User.Specialty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class ConsultationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer request_id;

    private Date requestDate;

    @Enumerated(EnumType.ORDINAL)
    private Specialty service;

    private Boolean done;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient.id")
    private Patient patientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Employee.id")
    private Employee employeeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    private Report report;

    public ConsultationRequest(Date requestDate, Specialty service) {
        this.requestDate = requestDate;
        this.service = service;
        this.done = false;
    }

    public String getEmployeeId(){
        if(employeeId == null) return null;
        else return "Dr. " + employeeId.getLastName();
    }

    public String[] getPatientId(){
        if(patientId == null) return null;
        else{
            String[] array = {patientId.getFirstName() + " " + patientId.getLastName(), patientId.getAddress(), String.valueOf(patientId.getPhoneNumber())};
            return array;
        }
    }

    @Override
    public String toString() {
        return "ConsultationRequest [request_id=" + request_id + ", requestDate=" + requestDate + ", service=" + service
                + "]";
    }
}