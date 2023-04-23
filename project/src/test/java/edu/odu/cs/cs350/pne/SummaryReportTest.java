package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SummaryReportTest {
    
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
    public void getMarkerTest() {

        assertThat(report.getMarker(50, course1), is (' '));
        assertThat(report.getMarker(50, course1), not(is('*')));
        assertThat(report.getMarker(50, course1), not(is('a')));

        assertThat(report.getMarker(50, course2), is ('*'));
        assertThat(report.getMarker(50, course2), not(is(' ')));
        assertThat(report.getMarker(50, course2), not(is('a')));
    }


    @Test
    public void toStringTest() {

        assertTrue(report.toString().contains("Course"));
        assertTrue(report.toString().contains("Enrollment"));
        assertTrue(report.toString().contains("Projected"));
        assertTrue(report.toString().contains("Cap"));

        assertFalse(report.toString().contains("Class"));
    }
 
    @Test
    public double getEnrollmentPercentage() {
        SummaryReport semester = new SummaryReport();

        
    }
}
