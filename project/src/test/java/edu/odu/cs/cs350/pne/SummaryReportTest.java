package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.time.format.DateTimeParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SummaryReportTest {

    @Test
    public void testDefaultConstructor() {
        SummaryReport summaryReport = new SummaryReport();
        assertEquals(' ', summaryReport.getMarker());
    }

    @Test
    public void testParameterizedConstructorAndGetters() {
        SummaryReport summaryReport = new SummaryReport("CS120G", 46, 104, 120);
        assertEquals("CS120G", summaryReport.getCourse());
        assertEquals(46, summaryReport.getEnrollment());
        assertEquals(104, summaryReport.getProjectedEnrollmentVal());
        assertEquals(120, summaryReport.getCap());
    }
    
    @Test
    public void projectEnrollmentTest() {
        SummaryReport report = new SummaryReport();
        report.projectedEnrollment(88, 75);
        assertThat(report.getMarker(), is ('*'));
        assertThat(report.getMarker(), not(is(' ')));
        assertThat(report.getMarker(), not(is('a')));

        report.projectedEnrollment(33, 50);
        assertThat(report.getMarker(), is (' '));
        assertThat(report.getMarker(), not(is('*')));
        assertThat(report.getMarker(), not(is('a')));
    }



    @Test
    public void toStringTest() {
        SummaryReport semester = new SummaryReport();

        assertTrue(semester.toString().contains("Course"));
        assertTrue(semester.toString().contains("Enrollment"));
        assertTrue(semester.toString().contains("Projected"));
        assertTrue(semester.toString().contains("Cap"));

        assertFalse(semester.toString().contains("Class"));
    }
 
    // @Test
    // public double getEnrollmentPercentage() {
    //     SummaryReport semester = new SummaryReport();

        
    // }
    
    @Test
    public void testProjectedEnrollmentLessThanCap() {
        SummaryReport summaryReport = new SummaryReport("CS120G", 46, 104, 120);
        assertEquals(' ', summaryReport.projectedEnrollment(90, 120));
        assertEquals(' ', summaryReport.getMarker());
    }

    @Test
    public void testProjectedEnrollmentGreaterThanCap() {
        SummaryReport summaryReport = new SummaryReport("CS120G", 46, 104, 120);
        assertEquals('*', summaryReport.projectedEnrollment(130, 120));
        assertEquals('*', summaryReport.getMarker());
    }

    @Test
    void testGetEnrollmentProjectionWithFileNotFound() throws IOException {
        SummaryReport report = new SummaryReport();

        assertThrows(FileNotFoundException.class, () -> {
            report.getEnrollmentProjection(new String[] {"nonexistent.txt"});
            });
    }

    @Test
    void testGetEnrollmentProjectionWithInvalidDateFormat() throws IOException {
        SummaryReport report = new SummaryReport();

        assertThrows(DateTimeParseException.class, () -> {
            report.getEnrollmentProjection(new String[] {"./data/summary/History/202230/invalid_dates.txt"});
            });
    }

    @Test
    public void testGetEnrollmentProjection() throws IOException {

        // mock the input file with pre-reg date of 2023-01-01 and add deadline of 2023-01-15
        ClassLoader cl = getClass().getClassLoader();
        File file = new File(cl.getResource("summary-report-dates.txt").getFile());
        String input = "2023-01-01\n2023-01-15\n";
        Files.write(file.toPath(), input.getBytes());

        // capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // call the method and verify console output
        SummaryReport summaryReport = new SummaryReport();
        summaryReport.getEnrollmentProjection(new String[] {});
        String expectedOutput = "100% of enrollment period has elapsed.\n" +
                            "  Course     Enrollment      Projected        Cap             \n" +
                            "  * CS120G   46              66              120             \n";
        assertEquals(expectedOutput, outContent.toString());

        // restore standard console output
        System.setOut(System.out);
    }
}
