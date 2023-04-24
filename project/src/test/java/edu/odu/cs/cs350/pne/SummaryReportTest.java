package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SummaryReportTest {
    @Test
    public void testDefaultConstructor() {
        //SummaryReport summaryReport = new SummaryReport();
        //assertEquals(' ', summaryReport.getEnrMarker());
    }

    @Test
    public void testParameterizedConstructorAndGetters() {
        SummaryReport summaryReport = new SummaryReport("CS120G", 46, 104, 120);
        assertEquals("CS120G", summaryReport.getCourse());
        assertEquals(46, summaryReport.getEnrollment());
        assertEquals(104, summaryReport.getProjectedEnrollment());
        assertEquals(120, summaryReport.getCap());
    }
    
    Offering offer1;
    Offering offer2;
    Offering offer3;
    
    Section section1;
    Section section2;
    Section section3;
    Section section4;

    Course course1;
    Course course2;

    SummaryReport report;

    @BeforeEach
    public void setUp () throws Exception {

        offer1 = new Offering("SC450", 30, 7);
        offer2 = new Offering("SC065", 40, 3);
        offer3 = new Offering("SC188", 25, 4);

        section1 = new Section("29869", 30, 0);
        section2 = new Section("30065", 15, 0,"P3");
        section3 = new Section("21784", 25, 5);
        section4 = new Section("23746", 10, 0, "A1");

        course1 = new Course("CS", "115");
        course2 = new Course("CS", "120");

        section1.addOffering(offer1);
        section2.addOffering(offer2);
        section3.addOffering(offer3);

        course1.addSection(section1);
        course1.addSection(section2);
        course2.addSection(section3);
        course2.addSection(section4);

        report = new SummaryReport();

        report.addCourse(course1);
        report.addCourse(course2);
    }

    
    @Test
    public void getEnrMarkerTest() {

        assertThat(report.getEnrMarker(50, course1), is (' '));
        assertThat(report.getEnrMarker(50, course1), not(is('*')));
        assertThat(report.getEnrMarker(50, course1), not(is('a')));

        assertThat(report.getEnrMarker(50, course2), is ('*'));
        assertThat(report.getEnrMarker(50, course2), not(is(' ')));
        assertThat(report.getEnrMarker(50, course2), not(is('a')));
    }


    @Test
    public void toStringTest() {

        assertTrue(report.toString().contains("Course"));
        assertTrue(report.toString().contains("Enrollment"));
        assertTrue(report.toString().contains("Projected"));
        assertTrue(report.toString().contains("Cap"));

        assertFalse(report.toString().contains("Class"));
    }

    // @Test
    // void testGetEnrollmentProjectionWithFileNotFound() {
    //     SummaryReport report = new SummaryReport();
    
    //     assertThrows(FileNotFoundException.class, () -> {
    //         report.getEnrollmentProjection(new String[] {"nonexistent.txt"});
    //     });
    // }

    // @Test
    // void testGetEnrollmentProjectionWithInvalidDateFormat() throws IOException {
    //     SummaryReport report = new SummaryReport();

    //     assertThrows(DateTimeParseException.class, () -> {
    //         report.getEnrollmentProjection(new String[] {"./data/summary/History/202230/invalid_dates.txt"});
    //         });
    // }

    @Test
    public void testReadFileForSummaryReport() throws Exception
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
    
    // @Test
    // public void testGetEnrollmentProjection() throws IOException {

    //     // mock the input file with pre-reg date of 2023-01-01 and add deadline of 2023-01-15
    //     File file = new File("summary-report-dates.txt");
    //     String input = "2023-01-01\n2023-01-15\n";
    //     Files.write(file.toPath(), input.getBytes());

    //     // capture console output
    //     ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    //     System.setOut(new PrintStream(outContent));

    //     // call the method and verify console output
    //     SummaryReport summaryReport = new SummaryReport();
    //     summaryReport.getEnrollmentProjection(new String[] {});
    //     String expectedOutput = "100% of enrollment period has elapsed.\n" +
    //                         "  Course     Enrollment      Projected        Cap             \n" +
    //                         "  * CS120G   46              66              120             \n";
    //     assertEquals(expectedOutput, outContent.toString());

    //     // restore standard console output
    //     System.setOut(System.out);
    // }
}
