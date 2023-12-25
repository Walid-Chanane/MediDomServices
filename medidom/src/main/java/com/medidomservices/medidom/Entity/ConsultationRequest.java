package com.medidomservices.medidom.Entity;

import java.sql.Date;

import com.medidomservices.medidom.Entity.User.Patient;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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

    private Service service;

    @ManyToOne
    @JoinColumn(name = "id")
    private Patient userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    private Report report;

    public ConsultationRequest(Date requestDate, Service service, Patient userId) {
        this.requestDate = requestDate;
        this.service = service;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ConsultationRequest [request_id=" + request_id + ", requestDate=" + requestDate + ", service=" + service
                + "]";
    }
}