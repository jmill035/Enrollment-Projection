package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;

public class SemesterTest {

 @Test
 public void testSupplyDirectories(){

    Semester semester = new Semester();
    String pastDirectory = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/2022*" ;
    String currentDirectory = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/2023*" ; 

    assertTrue(semester.supplyDirectories(pastDirectory, currentDirectory));

 }
<<<<<<< HEAD
 
=======
  
>>>>>>> d0d2a2c1fd3e53733db406924ebee7c2dbc8f2aa
}