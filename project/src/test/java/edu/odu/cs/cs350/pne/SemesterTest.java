package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;


public class SemesterTest {

 @Test
 public void testSupplyDirectories(){

    Semester semester = new Semester();
    String pastDirectory = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/2022*" ;
    String currentDirectory = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/2023*" ; 

    assertTrue(semester.supplyDirectories(pastDirectory, currentDirectory));

 }
 @Test
   public void testReadFile()
   {
      ClassLoader cl = getClass().getClassLoader();
      File file1 = new File (cl.getResource("./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/dates.txt").getFile());
      assertThat(file1).exists().isFile().canRead();
   }

   @Test
      public void testCsvFile()
      {
         String csvPath = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230";
         File csvFolder = new File(csvPath);
         File[] fileArray = csvFolder.listFiles();
         List<String> csvFiles = new ArrayList<String>();
         for (int i = 0; i < fileArray.length; i++) {
               if (fileArray[i].isFile()) {
                  String fileName = fileArray[i].getName();
                  if (fileName.endsWith(".csv")) 
                  {
                    csvFiles.add(fileName);
                  }
               }
         }
        assertFalse(csvFiles.isEmpty(), "No CSV files found in directory " + csvPath);
    }
}
