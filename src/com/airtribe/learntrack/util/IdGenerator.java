package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentIdCounter = 100;
    private static int courseIdCounter = 10;
    private static int enrollmentIdCounter = 1000;
    //to restrict the object creation
    private IdGenerator(){};

    public static int getNextStudentId(){
        return ++studentIdCounter;
    }
    public static int getNextCourseId(){
        return ++courseIdCounter;
    }

    public static int getEnrollmentIdCounter() {
        return ++enrollmentIdCounter;
    }
}
