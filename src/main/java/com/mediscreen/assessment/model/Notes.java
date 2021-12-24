package com.mediscreen.assessment.model;

public class Notes {

    //fields
    private Long id;
    private Long patientId;
    private String notes;

    //constructor
    public Notes() {
    }

    public Notes(Long patientId, String notes) {
        this.patientId = patientId;
        this.notes = notes;
    }

    // getter & setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", notes='" + notes + '\'' +
                '}';
    }
}
