package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.*;

public class SemesterTest {
/* 
 @Test
 public void testSupplyDirectories()
 {

    Semester semester = new Semester();
    String pastDirectory = "src/test/data/summary/History/202230/2022*" ;
    String currentDirectory = "src/test/data/summary/History/202230/2023*" ; 
    //assertTrue(semester.supplyDirectories());

    assertTrue(semester.supplyDirectories(pastDirectory, currentDirectory));

   // String[] cliOutput = .getOutput();
   // assertEquals(pastDirectory, cliOutput[0]);
   // assertEquals(currentDirectory, cliOutput[1]);

 }
*/
   @Test
   public void testReadFile() throws Exception
   {
        // Check if the dates file was loaded correctly
        File file = new File("src/test/data/summary/History/202230/dates.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String preReg = reader.readLine();
        String addDeadline = reader.readLine();
        reader.close();

        // Check that the loaded dates match the expected values
        assertNotNull(preReg);
        assertNotNull(addDeadline);
        assertEquals("2022-10-31", preReg);
        assertEquals("2023-05-17", addDeadline);
   }

   @Test
   void testReadCsvFilesInFolder() {
       String folderPath = "src/test/data/summary/History/202230";
       File folder = new File(folderPath);
       File[] files = folder.listFiles();
       List<String> csvFiles = new ArrayList<>();
       
       for (File file : files) {
           if (file.isFile() && file.getName().endsWith(".csv")) {
               csvFiles.add(file.getName());
           }
       }
       
       assertFalse(csvFiles.isEmpty(), "No CSV files found in directory " + folderPath);
   }

   @Test
    void testDatesReadCorrectly() throws Exception {

        File file = new File("src/test/data/summary/History/202230/dates.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String preReg = reader.readLine();
        String addDeadline = reader.readLine();
        reader.close();

        LocalDate preRegDate = LocalDate.parse(preReg, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate addDeadlineDate = LocalDate.parse(addDeadline, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Assertions.assertEquals("2022-10-31", preRegDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Assertions.assertEquals("2023-05-17", addDeadlineDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
