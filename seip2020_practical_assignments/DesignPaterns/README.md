# Design Patterns Module

Design Patterns module is an intoduction in Design Patterns and Software Architecture and Modeling. This module reads a Java Source Code File either from the web or locally and calculates the LOC, NOM and NOC metrics. LOC, NOM and NOC stands for:

* LOC: Lines Of Code in a java source code file

* NOM: Number Of Methods in a java source code file

* NOC: Number Of Classes in a java source code file

 In the following sections I analyze mine design stategy for the Design Patterns module and I present the benefits and the tradeoffs of the selected design strategy. Finally I have attached an image that represents the UML Class Diagramm of the source code of the project.

 # Parts Of The Design

 The design consists of 14 classes that some of them communicate with others. Specifically the design consists of:

 * One Facade pattern (Facade class), which is responsible for the execution of all the operations of the project.

 * One Factory pattern for the SourceCodeAnalyzer class, which is called SourceCodeAnalyzerFactory and is responsible for the creation of all the necessary objects of SourceCodeAnalyzer class.

 * One abstract class called SourceCodeAnalyzer which is the parent class of three subclasses.

 * Three subclasses (CalculateLOC, CalculateNOM, CalculateNOC) that they inherit SourceCodeAnalyzer parent class and are responsible for the calculation of three different metrics, LOC, NOM and NOC.

 * One interface called SourceFileReader. 

 * Two classes(WebFileReader, LocalFileReader) that implement SourceFilereader interface and are responsible for recovery of all the contents of java source code file.

 * One Factory pattern for the MetricsFileExporter class, which is called MetricsFileExporterFactory and is responsible for the creation off the necessary object of MetricsFileExporter class.

 * One interface called MetricsFileExporter. 

 * Two classes(MetricsExporterCSV, MetricsExporterJSON) that implement MetricsFileExporter interface and are responsible for export of the file that contains all the calculated metrics

 * A DemoClent class that contains the main method and executes the program.

 # Why this specific pattern?

 All the decisions were made under the SOLID Design Priciples

 * All the classes such as CalculateLOC, CalculateNOM etc have now a single responsibililty. CalculateLOC, calculates LOC metric, CalculateNOM clalculates NOM metric, SourceCodeAnalyzerFactory initialize the correct objects of SourceCodeAnalyzer abstract class, WebFileReader and LocalFileReader reads a java source code file either from the web or locally and store its contents in a List or regular expresion(String), MetricsFileExporterFactory is responsible for the creation of correct object of MetricsFileExporter class, MetricsExporterCSV exports the calculated metrics in a csv file. So it is clear that all the classes have a specific functionality and they have only one reason to change.  

 * The extension of the functionality of some classes is very easy due to the usage of two interfaces and on abstract class that favor the extendibility of the project (Open-Closed Principle).

 * The usage of 2 different interfaces for two 2 different functionalities, favors the interface segregation principle. Different functionalities implement their own interface. 

 * Objects in the program are repleacable with instances of their subtypes without altering the correctenss of the programm due to the usage of high abstraction in the project (LSP).

 * Finally all the classes have no needless complexity(small if else statements), needless repetition(no repeated code in the classes), all the classes are easy to read because they have one single responsibility, some of the components can be reused to other projects(SourceCodeAnalyzers, SourceFileReaders and MetricsFileExporters), high extendibility duo to the abstraction and the system is easy to change it and to maintain it because every change is not forcing many other changes to other parts of the system.

 # Benefits and Tradeoffs

 ### Benefits
 * SourceCodeAnalyzers, SourceFileReaders and MetricsFileExporters are now more interchangable and more extendible duo to the high abstraction of the system. 
 That means that if somenone in the future wants to add more SourceCodeAnalyzers, SourceFileReaders and MetricsFileExporters, it is very easy to do it without to much changes in the source code of the system.

 * Reduced the overal complexity of the system. Now the number of if-else statements in the classes of the system is low. That makes the code more understantible to others developers.

 * Some components of the system such as SourceCodeAnalyzers, SourceFileReaders and MetricsFileExporters and all their corresponding factories classes are now reusable and transferable to other projects.

 * The usage of Factory classes seperates the logic of object instantiation from the client.

 * The usage of Facade class decouples the the subsystem for the client from the other two subsystems.

 * The client has few lines of code and doesn't execute any kind of functionality. The client only reads the arguments and run the program.

 * The dimensions of SourceCodeAnalyzers and SourceFileReaders can vary independently.

 * Adding new types of SourceFileReaders does not effect SourceCodeAnalyzers hierarchy and the opposite. 

 * Adding new SourceCodeAnalyzers rquire minimal changes in the SourceFileReaders hierarchy.

 ### Tradeoffs

 * The usage of Bridge Pattern provides two dimensions (SourceCodeAnalyzers, SourceFileReaders) expressed by one Abstraction/Interface, in a single inheritance tree.

 * Adding new SourceCodeAnalyzers and SourceFileReaders can cause subclass explosion because it requires to add several subclasses. However the addtion of new SourceCodeAnalyzers and SourceFileReaders requires a few changes in the code of other components.

 * The abality of adding new analyzer types is not provided.

