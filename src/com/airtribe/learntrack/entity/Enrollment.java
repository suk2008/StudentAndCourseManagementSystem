package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollStatus;

import java.time.LocalDate;

public class Enrollment {
   private int enrollmentId;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
//    private enum status{
//        ACTIVE, COMPLETED, CANCELLED
//    };
    private EnrollStatus status;
    public Enrollment(){}

    public Enrollment(int enrollmentId, int studentId, int courseId, LocalDate enrollmentDate, EnrollStatus status) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public EnrollStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId=" + enrollmentId +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", status=" + status +
                '}';
    }
}
