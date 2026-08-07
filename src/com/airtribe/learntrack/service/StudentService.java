package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    // Add Student with full details
    public Student addStudent(String firstName, String lastName, String email, String batch) throws InvalidInputException {
        Student student = new Student(
                IdGenerator.getNextStudentId(),
                InputValidator.requiredText(firstName, "First Name"),
                InputValidator.requiredText(lastName, "Last Name"),
                email == null ? "" : email.trim(),
                InputValidator.requiredText(batch, "Batch"),
                true
        );
        students.add(student);
        System.out.println("Student added successfully.");
        return student;
    }

    // Overloaded: Add Student without email
    public void addStudent(String firstName, String lastName, String batch) throws InvalidInputException {
        addStudent(firstName, lastName, "", batch);
    }

    // List all students
    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Find student by ID
    public Student findStudentById(int id) throws EntityNotFoundException {
        for (Student student : students) {
            if (student.getId() == id) return student;
        }
        throw new EntityNotFoundException("Student with ID " + id + " not found.");
    }

    // Deactivate student
    public void deactivateStudent(int id) {
        try {
            Student student = findStudentById(id);
            student.setActive(false);
            System.out.println("Student deactivated successfully.");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update student email
    public void updateStudentEmail(int id, String email) {
        try {
            Student student = findStudentById(id);
            student.setEmail(email);
            System.out.println("Student email updated successfully.");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
