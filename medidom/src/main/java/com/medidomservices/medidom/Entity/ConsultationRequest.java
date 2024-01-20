package com.medidomservices.medidom.Entity;

import java.sql.Date;

import com.medidomservices.medidom.Entity.User.Employee;
import com.medidomservices.medidom.Entity.User.Patient;
import com.medidomservices.medidom.Entity.User.Specialty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @ManyToOne
    @JoinColumn(name = "Patient.id")
    private Patient patientId;

    @ManyToOne
    @JoinColumn(name = "Employee.id")
    private Employee employeeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    private Report report;

    public ConsultationRequest(Date requestDate, Specialty service, Patient patientId) {
        this.requestDate = requestDate;
        this.service = service;
        this.patientId = patientId;
        this.done = false;
    }

    public String getEmployeeId(){
        if(employeeId == null) return null;
        else return employeeId.getEmail();
    }

    public String getPatientId(){
        if(patientId == null) return null;
        else return patientId.getEmail();
    }

    @Override
    public String toString() {
        return "ConsultationRequest [request_id=" + request_id + ", requestDate=" + requestDate + ", service=" + service
                + "]";
    }
}