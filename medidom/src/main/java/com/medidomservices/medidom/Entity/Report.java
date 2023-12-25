package com.medidomservices.medidom.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Report {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int report_id;

    private String stateOfPatient;

    private String treatment;
    
    private String recommendation;

    public Report(String stateOfPatient, String treatment, String recommendation) {
        this.stateOfPatient = stateOfPatient;
        this.treatment = treatment;
        this.recommendation = recommendation;
    }

}
