package com.mediscreen.assessment.controller;


import com.mediscreen.assessment.model.Patient;
import com.mediscreen.assessment.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost")
@RestController
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;


    @RequestMapping(value = "/assess/id")
    public String accessPatient(@RequestParam(value="id") Long id) {

        Patient patientToAccess = assessmentService.getPatientDemographics(id);

        return assessmentService.generateAssessment(patientToAccess);

    }

    @RequestMapping("/assess/familyName")
    public String accessPatient(@RequestParam(value="familyName") String familyName) {

        Patient patientToAccess = assessmentService.getPatientDemographicsByString(familyName);

        return assessmentService.generateAssessment(assessmentService.getPatientDemographicsByString(patientToAccess.getFamilyName()));
    }



}
