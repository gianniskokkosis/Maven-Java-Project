[![Build Status](https://travis-ci.com/gianniskokkosis/2nd-Assignment-SEIP.svg?token=L1eLS59Zf57fDVQXrFCy&branch=development)](https://travis-ci.com/gianniskokkosis/2nd-Assignment-SEIP)

# 2nd Assignment SEIP

This is the second individual assignment in Software Engineering in Practice (SEiP). This assignment contains a simple multi module maven project. The assignment is for the purposes of the course Software Engineering in Practice offered by the Department of Managment Science and Technology of Athens University Of Economics and Business(AUEB).


## Project Structure
This repository contains the following:
1) A parent maven module called seip2020_practical_assignments
2) A child maven module, of the above parent module, called gradeshistogram

The child module, gradeshistogram, creates a histogram for a given file of numbers that user provides through the command line. The details of this module are presented after the Project Build Section. 


## Project Build
First of all clone this repository to your local machine
```
git clone https://github.com/gianniskokkosis/2nd-Assignment-SEIP.git
```

Then navigate to the direcoty of the parent module seip2020_practical_assignments
```
cd seip2020_practical_assignments
```

Finally hit the following command in order to build all modules
```
mvn package jacoco:report
```


### Grades Histogram
Histogram Generator module generates a histogram chart from a file with integers numbers, that is given by the user through the command line as an argument. This module requires one dependency called JFreeChart which is a runtime dependency and it is packaged in the main jar (fat-jar). To create a fat-jar you need to use the ```maven-assembly-plugin``` plugin plugin and also define the class that is the main entry point of the system (the class that contains the main method).

```
<!--Plugin that generates "fat-jar"-->
<plugin>
  <artifactId>maven-assembly-plugin</artifactId>

    <configuration>
      <archive>
        <manifest>
          <mainClass>gradeshistogram.HistogramGenerator</mainClass> 
        </manifest>
      </archive>
      <descriptorRefs>
        <descriptorRef>jar-with-dependencies</descriptorRef>
      </descriptorRefs>
    </configuration>

    <executions>
      <execution>
        <id>make-assembly</id>
        <phase>package</phase>
        <goals>
          <goal>single</goal>
        </goals>
      </execution>
    </executions>

</plugin>
```

The produced jar is located in the target directory and can be executed as following:
```
$ java -jar seip2020_practical_assignments/gradeshistogram/target/gradeshistogram-1.0-SNAPSHOT-jar-with-dependencies.jar  C:/.../a path to the file/.../
```

### Math Operations

For more informations about Math Operations click the link below

[Click Here](seip2020_practical_assignments/math_operations/README.md) to learn more 

### Design Patterns

[Click here](seip2020_practical_assignments/DesignPatterns/README.md)

### Developed by: ```gianniskokkosis```