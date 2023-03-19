package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SemesterTest {

 @Test
 public void testSupplyDirectories(){

    Semester semester = new Semester();
    String pastDirectory = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/2022*" ;
    String currentDirectory = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/2023*" ; 

    assertTrue(semester.supplyDirectories(pastDirectory, currentDirectory));

 }
 }