# JVM Basics

## What is JDK?
JDK (Java Development Kit) is used to develop Java applications. It contains the compiler, JVM, JRE, and other tools required to write, compile, and run Java programs.

---

## What is JRE?
JRE (Java Runtime Environment) provides the environment required to run Java applications. It contains the JVM and the libraries needed during execution.

---

## What is JVM?
JVM (Java Virtual Machine) is responsible for executing Java bytecode. It converts the bytecode into machine code so that it can run on the operating system.

---

## What is Bytecode?
When a Java source file (`.java`) is compiled using the Java compiler, it generates a `.class` file. This `.class` file contains bytecode.
Bytecode is platform-independent, which means it can run on any operating system that has a compatible JVM.

---

## What does "Write Once, Run Anywhere" mean?
Java programs are compiled into bytecode instead of platform-specific machine code. The same bytecode can be executed on Windows, Linux, or macOS without changing the source code.
This is possible because every operating system has its own JVM. The JVM converts the bytecode into machine code for the underlying operating system, allowing the same Java program to run on different platforms.