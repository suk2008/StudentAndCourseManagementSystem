package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.ArrayList;

public class CourseService {
    private ArrayList<Course> courses = new ArrayList<>();

    // Add Course
    public Course addCourse(String name, String description, int durationInWeeks) throws InvalidInputException {
        Course course = new Course(IdGenerator.getNextCourseId(), InputValidator.requiredText(name, "Course Name"),
                description == null ? "" : description.trim(), InputValidator.positiveNumber(durationInWeeks, "Duration"), true);
        courses.add(course);
        System.out.println("Course added successfully.");
        return course;
    }

    // List all Courses
    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course course : courses)   System.out.println(course);
    }

    // Find the Course
    public Course findCourseById(int id) throws EntityNotFoundException {
        for (Course course : courses) {
            if (course.getCourseId() == id) return course;
        }
        throw new EntityNotFoundException("Course with ID " + id + " not found.");
    }

    // Toggle Course Status
    public void toggleCourseStatus(int id) {
        try {
            Course course = findCourseById(id);
            course.setActive(!course.isActive());
            System.out.println("Course status updated successfully.");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
