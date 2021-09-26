package com.mediscreen.assessment.model;


import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;


public class Patient {

    private Long id;
    private String givenName;
    private String familyName;
    private Date birthdate;
    private String sex;
    private String homeAddress;
    private String phoneNumber;

    public Patient() {
    }

    public Patient(Long id, String givenName, String familyName, Date birthdate, String sex, String homeAddress, String phoneNumber) {
        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;
        this.birthdate = birthdate;
        this.sex = sex;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    // method calculate age

    public int getAge() {

        LocalDate birthdate = this.birthdate.toLocalDate();
        LocalDate currentDate = LocalDate.now();

        return Period.between(birthdate, currentDate).getYears();
    }




}
