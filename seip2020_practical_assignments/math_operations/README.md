# Math Operations

Math Operations is a simple maven module, that serves a basic intoduction to Unit Tesing using the JUnit framework of Java programming language. In the following lines you will read further information about the functionality of this module. Math operations module also uses the JaCoCo code coverage report. More info and details about JaCoCo code coverage report are provided below. 

# Basic arithmetic operations

Math Operations module provides some basic arithmetic operations such as multiplication and division

# Advanced mathematic topics

Math Operations also provides some more advanced mathematic topics related to integeres numbers such as the calculation of the factorial for a given number or the calculation if a given number is prime or not. 

# What is JaCoCo and what it measures?

JaCoCo stands for "Java Code Coverage" and it is usually used to measure the code coverage by unit testing. In other words JaCoCo report shows you a percentage that indicates how many lines and output cases of your code is beeing tested properly. It also shows you the lines of the code that has a unique test case and they are completly tested, by highlighting them with green color, how many lines of the code are beeing partialy tested and finally how many lines of the code are not tested at all. 

# How to generate a JaCoCo code covarage report

For maven projects just add the jacoco dependency in the main pom.xml of the project.

```
<build>
    <plugins>
        <plugin>
            <groupId>org.jacoco</groupId>
            <artifactId>jacoco-maven-plugin</artifactId>
            <version>0.8.3</version>
            <executions>
                <execution>
                    <id>prepare-agent</id>
                    <goals>
                        <goal>prepare-agent</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
After the project build(mvn package jacoco:report), verify that the jacoco code coverage report has been successfully generated at the target/site/jacoco location of each module of your project.