package com.airtribe.learntrack.entity;

public class Student extends Person {
//    private int studentId;
//    private String firstName;
//    private String lastName;
//    private String email;
    private String batch;
    private boolean active;

    public Student(){}
    public Student(int personId, String firstName, String lastName, String email, String batch, boolean active) {
        super(personId, firstName, lastName, email);
//        this.studentId = studentId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
        this.batch = batch;
        this.active = active;
    }

    public Student(int id, String firstName, String lastName, String batch) {
        super(id,firstName,lastName);
        this.batch = batch;
        this.active = true;
    }

    @Override
    public String getDisplayName() {
        return super.getDisplayName() + " : Student";
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", batch='" + batch + '\'' +
                ", active=" + active +
                '}';
    }

}
