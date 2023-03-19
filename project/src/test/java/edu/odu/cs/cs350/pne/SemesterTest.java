package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;

public class SemesterTest {

 @Test
 public void testSupplyDirectories(){

    Semester semester = new Semester();
    String pastDirectory = "path/to/past/directory" ;
    String currentDirectory = "path/to/current/directory" ; 

    assertTrue(semester.supplyDirectories(pastDirectory, currentDirectory));

 }
 @Test
   public void testSupplyCutoff(){
   ClassLoader cl = getClass().getClassLoader();
   File file1 = new File (cl.getResource("./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/dates.txt").getFile());
   assertThat(file1).exists().isFile().canRead();
 }
  
}