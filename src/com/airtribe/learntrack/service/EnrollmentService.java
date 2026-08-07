package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;

public class EnrollmentService {
    private ArrayList<Enrollment> enrollments = new ArrayList<>();
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    // Enroll the Student
    public Enrollment enrollStudent(int studentId, int courseId) throws EntityNotFoundException {
        // Throws exception if not found
        studentService.findStudentById(studentId);
        courseService.findCourseById(courseId);

        Enrollment enrollment = new Enrollment(IdGenerator.getEnrollmentIdCounter(), studentId, courseId, LocalDate.now(), EnrollStatus.ACTIVE);
        enrollments.add(enrollment);
        System.out.println("Student enrolled successfully.");
        return enrollment;
    }

    // View Enrollments for a Student
    public void viewEnrollments(int studentId) throws EntityNotFoundException {
        studentService.findStudentById(studentId); // check if student exists
        boolean found = false;
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                System.out.println(enrollment);
                found = true;
            }
        }
        if (!found)   System.out.println("No enrollments found for student ID " + studentId);
    }

    // Update Enrollment Status
    public void updateEnrollmentStatus(int enrollmentId, String status) throws EntityNotFoundException {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getEnrollmentId() == enrollmentId) {
                try {
                    enrollment.setStatus(EnrollStatus.valueOf(status.toUpperCase()));
                    System.out.println("Enrollment status updated successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid status. Use ACTIVE, COMPLETED, or CANCELLED.");
                }
                return;
            }
        }
        throw new EntityNotFoundException("Enrollment with ID " + enrollmentId + " not found.");
    }
}

