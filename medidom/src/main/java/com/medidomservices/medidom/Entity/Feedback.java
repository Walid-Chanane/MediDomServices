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
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedback_id;

    private int qualityOfServices;

    private int punctualityOfServices;

    public Feedback(int qualityOfServices, int punctualityOfServices) {
        this.qualityOfServices = qualityOfServices;
        this.punctualityOfServices = punctualityOfServices;
    }  

}
