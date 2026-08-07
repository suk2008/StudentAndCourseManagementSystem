package com.airtribe.learntrack.entity;

public class Trainer extends Person{
    private String specialization;
    private int experienceInYears;
    private String department;
    private boolean active;

    public Trainer(){}

    public Trainer(int id, String firstName, String lastName, String email, String specialization, int experienceInYears, String department, boolean active) {
        super(id, firstName, lastName, email);
        this.specialization = specialization;
        this.experienceInYears = experienceInYears;
        this.department = department;
        this.active = active;
    }

    @Override
    public String getDisplayName() {
        return super.getDisplayName()+ " : " +specialization+" Trainer";
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(int experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceInYears=" + experienceInYears +
                ", department='" + department + '\'' +
                ", active=" + active +
                '}';
    }

}
