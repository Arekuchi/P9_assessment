package com.mediscreen.assessment;

//import com.mediscreen.assessment.controller.AssessmentController;
//import com.mediscreen.assessment.model.Patient;
//import com.mediscreen.assessment.service.DiabeteRiskLevel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
class AssessmentApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	MockMvc mockMvc;

//	@Autowired
//	DiabeteRiskLevel diabeteRiskLevel;

//	@Autowired
//	AssessmentController assessmentController;

//	Long idTest = 3L;
//	Date dateTest = Date.valueOf(LocalDate.now());
//	String result = "Patient : Alfred Bush age : 36 diabete assessment is : Borderline";
//	Patient patientTest = new Patient("givenTest", "familyTest", dateTest, "M", "addressTest", "555222222");

	@Test
	public void accessPatientTest() {

//		when(assessmentController.accessPatient(any().toString())).thenReturn(result);
//		assessmentController.accessPatient(any().toString());
//		verify(assessmentController, times(1)).accessPatient(any().toString());

	}



}
