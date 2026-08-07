# Setup Instructions

## JDK Version

The project was developed using:

- JDK 18
- IntelliJ IDEA Community Edition

You can verify the installed Java version by running:

```bash
java -version
```

Example:

```text
java version "18.0.1.1" 2022-04-22
Java(TM) SE Runtime Environment (build 18.0.1.1+2-6)
Java HotSpot(TM) 64-Bit Server VM (build 18.0.1.1+2-6, mixed mode, sharing)
```

---

## Running the Project

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure JDK 17 is configured as the Project SDK.
4. Navigate to the `Main.java` file.
5. Run the application.

---

## Hello World

To verify that Java is installed correctly, create a simple Java program.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
```

### Output

```text
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.2\lib\idea_rt.jar=51430:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.2\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\kalyanisukriti\AirtribeProjects\StudentAndCourseManagementSystem\out\production\StudentAndCourseManagementSystem Main
Hello world!

Process finished with exit code 0
```