package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SemesterReportTest {
    
    @Test
    public void projectEnrollmentTest() {
        SemesterReport semester = new SemesterReport();
        
        semester.marker = semester.projectedEnrollment(88, 75);
        assertThat(semester.marker, is ('*'));
        assertThat(semester.marker, not(is(' ')));
        assertThat(semester.marker, not(is('a')));

        semester.marker = semester.projectedEnrollment(33, 50);
        assertThat(semester.marker, is (' '));
        assertThat(semester.marker, not(is('*')));
        assertThat(semester.marker, not(is('a')));
    }



    @Test
    public void toStringTest() {
        SemesterReport semester = new SemesterReport();

        assertTrue(semester.toString().contains("Course"));
        assertTrue(semester.toString().contains("Enrollment"));
        assertTrue(semester.toString().contains("Projected"));
        assertTrue(semester.toString().contains("Cap"));

        assertFalse(semester.toString().contains("Class"));
    }
}
