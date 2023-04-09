package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.*;

public class SemesterTest {

 @Test
 public void testSupplyDirectories(){

    Semester semester = new Semester();
    String pastDirectory = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/2022*" ;
    String currentDirectory = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/2023*" ; 

    assertTrue(semester.supplyDirectories(pastDirectory, currentDirectory));

 }
 @Test
   public void testReadFile() throws Exception
   {
        // Check if the dates file was loaded correctly
        ClassLoader cl = getClass().getClassLoader();
        File file = new File(cl.getResource("./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/dates.txt").getFile());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String preReg = reader.readLine();
        String addDeadline = reader.readLine();
        reader.close();

        // Check that the loaded dates match the expected values
        assertNotNull(preReg);
        assertNotNull(addDeadline);
        assertEquals("2022-01-01", preReg);
        assertEquals("2022-01-15", addDeadline);
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
