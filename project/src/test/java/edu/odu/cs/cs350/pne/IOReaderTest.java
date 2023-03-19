package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOReaderTest {

   private final String[] filepaths = {

    "project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/2022-12-20.csv";
   }
    @Test
    void testCSVReaderOutput() {
        ByteArrayOutputStrem outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        CSVReader.main(null);
        String expectedOutput = 
        "Seats,CRN,SUBJ,CRSE,TITLE,CR HRS,XLST CAP,ENR,LINK,XLST GROUP,SCHED TYPE,,CAMPUS,INSM,PRINT?,TIME,DAYS,BLDG,ROOM,OVERRIDE,INSTRUCTOR,,OVERALL CAP,OVERALL ENR,,,PTRM START,PTRM END,WL CAP,WL,WL REMAIN,NOTES,COMMENTS,COLL \n" +
        "23","32321","CS","112","INFO LIT FORMER ENGN MAJORS","1","25","2","","SC201","A","I","B","ASYN","Y","HOURS ARR","","WEB2","","","GUPTA,REKHA","","25","2","1","ASYN","15-MAY-23","24-JUN-23","0","0","0";
        assertEquals(expectOutput, outContent.toString());
            }
}






