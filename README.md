# DECATHLON
Task description:

* In this assignment your task is to write a Java program that would calculate the results of a Decathlon
  competition.
# Getting Started

### Required software
The following are the initially required software pieces:

1. Maven: it can be downloaded from https://maven.apache.org/download.cgi#.
2. Git: it can be downloaded from https://git-scm.com/downloads.
3. Java 1.8: it can be downloaded from https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html.
   Follow the installation guide for each software website link and check your software versions from the command line to verify that they are all installed correctly.

#### Cloning It
Now it is the time to open terminal or git bash command line, and then clone the project under any of your favorite places with the following command:

> git clone https://github.com/Rajesh1761/Decathon.git
### Guides
### Using an IDE
I recommend that you work with your Java code using an IDE that supports the development of Spring Boot applications such as **Spring Tool Suite** or **IntelliJ IDEA Community | Ultimate Edition**.

All you have to do is fire up your favorite IDE -> open or import the parent folder **Decathlon**, and everything will be ready for you.

### Building & Running The System

* Steps to start Rest API project.
    * Once project imported in **Intellij**, Project is available in **Project** section.
    * Open **com.kuehen.nagel.decathlon.DecathlonApplication** file.
    * Update application.properties for input and output file location.
    * Now right click on that file click RUN from context menu.
* Otherwise, open folder where files were checkout from GIT and follow the following steps:
  * mvn clean install
  * **java -jar -Ddecathlon.athletic.input.file=/tmp/results.csv -Ddecathlon.athletic.output.file=/tmp/ Decathlon-1.0.jar**
    

