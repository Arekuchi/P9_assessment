package com.mediscreen.assessment.service;

import com.mediscreen.assessment.model.Patient;
import org.springframework.stereotype.Service;

public interface AssessmentService {

    String generateAssessment(Patient patient);
    Patient getPatientDemographics(Long patId);
    Patient getPatientDemographicsByString(String familyName);
    
}
