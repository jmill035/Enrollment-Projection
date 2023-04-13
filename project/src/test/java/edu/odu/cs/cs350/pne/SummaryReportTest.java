package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SummaryReportTest {
    
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
    public void projectedEnrollmentValueTest()
    {
        SummaryReport sem = new SummaryReport();
        
    }
}
