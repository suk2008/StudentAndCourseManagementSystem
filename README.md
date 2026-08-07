# Student And Course Management System

## About the Project

This is a console-based application built using Core Java to manage students, courses, and enrollments.

The project was developed to strengthen Core Java concepts by implementing a simple real-world use case instead of writing standalone examples. It focuses on object-oriented programming, collections, exception handling, and writing clean, modular code.

The application stores data in memory using `ArrayList` and provides a menu-driven interface for performing different operations.

---

## Features

### Student Management
- Add a new student
- View all students
- Search student by ID
- Update student details
- Deactivate a student

### Course Management
- Add a new course
- View all courses
- Activate or deactivate a course

### Enrollment Management
- Enroll a student in a course
- View student enrollments
- Mark enrollment as Completed or Cancelled

---

## Technologies Used

- Java
- Core Java
- OOP
- Collections (ArrayList)
- Exception Handling
- IntelliJ IDEA / Eclipse

---

## Project Structure

```
src
└── com.airtribe.learntrack
    ├── entity
    ├── com.airtribe.learntrack.service
    ├── exception
    ├── util
    └── ui
```

### Package Description

| Package | Purpose |
|----------|---------|
| entity | Contains Student, Course, Enrollment and Person classes |
| com.airtribe.learntrack.service | Business logic for managing students, courses and enrollments |
| util | Utility classes like IdGenerator and InputValidator |
| exception | Custom exceptions |
| ui | Console menu and Main class |

---

## OOP Concepts Used

### Encapsulation
All entity classes use private fields with public getters and setters.

### Inheritance
Student extends Person to reuse common properties.

### Polymorphism
Method overriding is used to customize display information.

### Constructor Overloading
Different constructors are provided where required.

### Static Members
IdGenerator uses static methods and counters to generate unique IDs.

---

## Collections

ArrayList is used to store Students, Courses and Enrollments because the data size is dynamic and can grow during runtime.

---

## Exception Handling

Custom exceptions are used for scenarios like invalid IDs or missing records.

The application also handles invalid user input using try-catch blocks so the program does not terminate unexpectedly.

---

## How to Run

1. Clone the repository

```
git clone <repository-url>
```

2. Open the project in IntelliJ IDEA or Eclipse.

3. Run the `Main.java` file.

4. Follow the menu displayed on the console.

---

## Class Diagram

Person
------
id
firstName
lastName
email

        ▲
        │
 -----------------
│               │
Student      Trainer
--------------
batch         specialization
active        experienceInYears
department
active

StudentService ─────────► Student

CourseService ──────────► Course

EnrollmentService ──────► Enrollment

Enrollment
   │
   ├────────► Student
   │
   └────────► Course

IDGenerator

                            +----------------------+
                            |       Person         |
                            +----------------------+
                            | - id : int           |
                            | - firstName : String |
                            | - lastName : String  |
                            | - email : String     |
                            +----------------------+
                            | + getDisplayName()   |
                            +----------^-----------+
                                       |
                         extends        |
                                       |
                            +----------------------+
                            |      Student         |
                            +----------------------+
                            | - batch : String     |
                            | - active : boolean   |
                            +----------------------+
                            | + getters/setters    |
                            +----------------------+

                 +---------------------------+
                 |          Course           |
                 +---------------------------+
                 | - id : int                |
                 | - courseName : String     |
                 | - description : String    |
                 | - durationInWeeks : int   |
                 | - active : boolean        |
                 +---------------------------+

                 +----------------------------+
                 |        Enrollment          |
                 +----------------------------+
                 | - id : int                 |
                 | - studentId : int          |
                 | - courseId : int           |
                 | - enrollmentDate : Date    |
                 | - status : String          |
                 +----------------------------+

────────────────────────────────────────────────────

+-------------------------+
|     StudentService      |
+-------------------------+
| + addStudent()          |
| + updateStudent()       |
| + removeStudent()       |
| + listStudents()        |
+-----------+-------------+
            |
            | manages
            v
         Student

+-------------------------+
|      CourseService      |
+-------------------------+
| + addCourse()           |
| + updateCourse()        |
| + listCourses()         |
+-----------+-------------+
            |
            | manages
            v
         Course

+-----------------------------+
|    EnrollmentService        |
+-----------------------------+
| + enrollStudent()           |
| + completeEnrollment()      |
| + cancelEnrollment()        |
+--------------+--------------+
               |
               | manages
               v
          Enrollment

+----------------------+
|     IdGenerator      |
+----------------------+
| + getNextStudentId() |
| + getNextCourseId()  |
+----------------------+
---

## Future Improvements

Some features that can be enhanced later:

- Database integration (MySQL)
- Spring Boot REST APIs
- Login and Authentication
- File Storage
- JUnit Test Cases
- Logging
- Docker Support

---

## Author

**Sukriti Kalyani**
