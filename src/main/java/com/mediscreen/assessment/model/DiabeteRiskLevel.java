package com.mediscreen.assessment.model;



    /* Les patients peuvent avoir 4 niveaux de risques.

    - None
    - Bordeline
    - In danger
    - Early onset

    Les règles pour déterminer les niveaux de risques sont les suivants :

    - None : Quand le patient n'a aucune Notes de docteur qui contient les 4 terminologies précédemment énoncés.

    - Borderline : Quand le patient a deux des terminologies précédemment énoncés
        ET
        agés de +30 ans.

    - In danger : Dépend de l'âge ET du sexe du patient.
            Si le patient est : <30 ans ET mâle ET a au moins 3 trigger.

            Si le patient est : <30 ans ET femelle ET a au moins 4 trigger.
            Si le patient est : >30 ans ET femelle ET a au moins 6 trigger.

     - Early onset : Dépend de l'âge ET du sexe du patient.
            Si le patient est : <30 ans ET mâle ET a au moins 5 trigger.

            Si le patient est : <30 ans ET femelle ET a au moins 7 trigger.
            Si le patient est : >30 ans ET femelle ET a au moins 8 trigger


      Les trigger (critères) sont :
      "Hemoglobin A1C", "Microalbumin", "Body Height", "Body Weight", "Smoker",
      "Abnormal", "Cholesterol", "Dizziness", "Relapse", "Reaction", "Antibodies"


     */

import java.util.LinkedHashMap;
import java.util.List;

public class DiabeteRiskLevel {

    private final String[] riskLevel = {"None", "Borderline", "In danger", "Early onset"};

    enum Assessment {

        ASSESSMENT_NONE(0),
        ASSESSMENT_BORDERLINE(1),
        ASSESSMENT_IN_DANGER(2),
        ASSESSMENT_EARLY_ONSET(3);

        private int value;

        Assessment(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private final String[] triggers = {"Hemoglobin A1C", "Microalbumin", "Body Height", "Body Weight", "Smoker",
            "Abnormal", "Cholesterol", "Dizziness", "Relapse", "Reaction", "Antibodies"};


    private final int NUM_BORDERLINE_TRIGGERS = 2;
    private final int NUM_IN_DANGER_TRIGGERS_MALE_UNDER_30 = 3;
    private final int NUM_IN_DANGER_TRIGGERS_FEMALE_UNDER_30 = 4;
    private final int NUM_IN_DANGER_TRIGGERS_OVER_30 = 6;
    private final int NUM_EARLY_ONSET_TRIGGERS_MALE = 5;
    private final int NUM_EARLY_ONSET_TRIGGERS_FEMALE_UNDER_30 = 7;



    // Méthode pour récupérer le nombre de critère des notes du médecin.
    private int generateNumberOfTriggerTerm(List<LinkedHashMap<String, String>> notes) {
        int numberOfTriggerTerm = 0;

        for(LinkedHashMap<String, String> note : notes) {
            String doctorNote = note.get("note");
            for(String trigger : triggers) {
                if(doctorNote.contains(trigger)) {
                    ++numberOfTriggerTerm;
                }
            }
        }


        return numberOfTriggerTerm;
    }



    //Méthodes pour définir le niveaux de risques.
    private Boolean isEarlyOnset(int age, int triggerTerm, String sex) {

        if(sex.equals("M")) {
            if(triggerTerm >= NUM_EARLY_ONSET_TRIGGERS_MALE) {
                return true;
            }
            return false;
        } else {
            if(age < 30) {
                if(triggerTerm >= NUM_EARLY_ONSET_TRIGGERS_FEMALE_UNDER_30) {
                    return true;
                }
            } else if (triggerTerm > NUM_EARLY_ONSET_TRIGGERS_FEMALE_UNDER_30) {
                return true;
            }
        }
        return false;
    }

    private Boolean isInDanger(int age, int triggerTerm, String sex) {

        if(sex.equals("M")) {
            if(age < 30) {
                if(triggerTerm >= NUM_IN_DANGER_TRIGGERS_MALE_UNDER_30) {
                    return true;
                }
            }
        } else {
            if(age < 30) {
                if(triggerTerm >= NUM_IN_DANGER_TRIGGERS_FEMALE_UNDER_30) {
                    return true;
                }
            }
        }
        return triggerTerm > NUM_IN_DANGER_TRIGGERS_OVER_30;

    }

    private Boolean isBorderline(int age, int triggerTerm) {

        return (age > 30)&&(triggerTerm >= NUM_BORDERLINE_TRIGGERS);

    }



    // Méthode pour générer le niveau de risque.
    private Assessment generateAssessmentValue(int age, int triggerTerm, String sex) {

        if(isEarlyOnset(age, triggerTerm, sex)) {
            return Assessment.ASSESSMENT_EARLY_ONSET;
        }

        if(isInDanger(age, triggerTerm, sex)) {
            return Assessment.ASSESSMENT_IN_DANGER;
        }

        if(isBorderline(age, triggerTerm)) {
            return Assessment.ASSESSMENT_BORDERLINE;
        }

        return Assessment.ASSESSMENT_NONE;
    }




    // Méthode pour générer toutes les informations
    public String access(Patient patient, List<LinkedHashMap<String,String>> notes) {
        String assessment = evaluateAssessment(patient, notes);
        return generatePatientResult(patient, assessment);
    }


    // Méthode pour générer l'assessment du patient
    private String evaluateAssessment(Patient patient, List<LinkedHashMap<String,String>> notes) {
        int age = patient.getAge();
        int numTriggerTerms = generateNumberOfTriggerTerm(notes);
        Assessment assessment = generateAssessmentValue (age, numTriggerTerms, patient.getSex());
        System.out.println("Patient is " + age + " years old, with " + numTriggerTerms + " trigger words, and assessment of: " + assessment);
        return riskLevel [assessment.getValue()];
    }


    // Méthode pour générer le résultat du patient (nom, age, et niveau de risque).
    private String generatePatientResult(Patient patient, String assessment) {

        return "Patient : " + patient.getGivenName() + " " + patient.getFamilyName() + " age : " + patient.getAge() + " diabete assessment is : " + assessment;
    }



}
