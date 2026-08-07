package com.airtribe.learntrack.UI;

import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class ConsoleUI {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            try {
                System.out.print("Enter your choice : ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        studentMenu();
                        break;
                    case 2:
                        courseMenu();
                        break;
                    case 3:
                        enrollmentMenu();
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Thank you for using Student And Course Management System.");
                        break;
                    default:
                        System.out.println("Invalid Option!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid option.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n========== Student And Course Management System ==========");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("4. Exit");
    }

    //start with Student Menu Option
    private static void studentMenu() {
        System.out.println("\n------ Student Menu ------");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Deactivate Student");
        try {
            //take user input : enter choice for student menu
            System.out.print("Enter your choice : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                //adding new Student entry
                case 1:
                    System.out.print("First Name : ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name : ");
                    String lastName = scanner.nextLine();

                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Batch : ");
                    String batch = scanner.nextLine();
                    System.out.println("Saved: "+ studentService.addStudent(firstName, lastName, email, batch));
                    break;
                //list all students
                case 2:
                    studentService.listStudents();
                    break;
                //Find Student Details
                case 3:
                    System.out.print("Enter Student Id : ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println(studentService.findStudentById(id));
                    break;
                //to deactivate the student id
                case 4:
                    System.out.print("Enter Student Id : ");
                    int studentId = Integer.parseInt(scanner.nextLine());
                    studentService.deactivateStudent(studentId);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid numeric choice.");
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //Course Menu
    private static void courseMenu() {
        System.out.println("\n------ Course Menu ------");
        System.out.println("1. Add Course");
        System.out.println("2. View Courses");
        System.out.println("3. Activate/Deactivate Course");
        try {
            //user input: choice for courses
            System.out.print("Enter your choice : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                //add new course
                case 1:
                    System.out.print("Course Name : ");
                    String name = scanner.nextLine();
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Duration (Weeks): ");
                    int weeks = Integer.parseInt(scanner.nextLine());
                    System.out.println("Saved : "+courseService.addCourse(name, description, weeks));
                    break;
                //list all courses
                case 2:
                    courseService.listCourses();
                    break;
                // search for course
                case 3:
                    System.out.print("Course Id : ");
                    int id = Integer.parseInt(scanner.nextLine());
                    courseService.toggleCourseStatus(id);
                    break;
                //search the course by id
                case 4:
                    System.out.print("Course Id : ");
                    int searchId = Integer.parseInt(scanner.nextLine());
                    try {
                        System.out.println(courseService.findCourseById(searchId));
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid numeric choice.");
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    ////Enrollment Menu
    private static void enrollmentMenu() {
        System.out.println("\n------ Enrollment Menu ------");
        System.out.println("1. Enroll Student");
        System.out.println("2. View Student Enrollments");
        System.out.println("3. Update Enrollment Status");
        try {
            // user input: enter the choice
            System.out.print("Enter your choice : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                //enroll the studnt
                case 1:
                    System.out.print("Student Id : ");
                    int studentId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Course Id : ");
                    int courseId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Saved : "+ enrollmentService.enrollStudent(studentId, courseId));
                    break;
                //check the enrollment
                case 2:
                    System.out.print("Student Id : ");
                    int id = Integer.parseInt(scanner.nextLine());
                    enrollmentService.viewEnrollments(id);
                    break;
                case 3:
                    System.out.print("Enrollment Id : ");
                    int enrollmentId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Status (ACTIVE/COMPLETED/CANCELLED): ");
                    String status = scanner.nextLine();
                    enrollmentService.updateEnrollmentStatus(enrollmentId, status);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid numeric choice.");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}