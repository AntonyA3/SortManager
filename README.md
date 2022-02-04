#Sort Manager Project \<WIP\>

##Summary
The sort Manager project is a command line application that allows the user (you) to input numbers in an 
array which you can sort and compare how, long it takes each algorithm to sort the arrays provided.
. The goal of this project was to demonstate the knowledge and
understanding of the **Log4J**, Design Patterns in particular the **Facade** and **Abstract Factory** design
pattern.


##Dependancies

These dependancies are required for testing and running of the application. These should
be added to the pom.xml file.

Junit Dependancy
        
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.8.2</version>
    </dependency>

Log4j Dependancies

    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.17.1</version>
    </dependency>
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-api</artifactId>
        <version>2.17.1</version>
    </dependency>

##Test Result
All unit tests have passed for this project

BinaryTreeSortTest

BinaryTreeTest

MergeSortTest

BubbleSortTest