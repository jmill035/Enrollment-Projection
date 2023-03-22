package edu.odu.cs.cs350.pne;

import org.hamcrest.core.IsEqual;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class CourseTest {

    @Test 
    public void WithoutXGroupConstructorTest() {
        Course course = new Course("32321", "CS", "112", 25, 2, "A1", 25, 2);

        assertThat(course.getCRN(), is("32321"));
        assertThat(course.getSubj(), is("CS"));
        assertThat(course.getCrse(), is("112"));
        assertThat(course.getXlstCap(), is(25));
        assertThat(course.getEnrollment(), is(2));
        assertThat(course.getLink(), is("A1"));
        assertThat(course.getXlstGroup(), is(""));
        assertThat(course.getOverallCap(), is(25));
        assertThat(course.getOverallEnr(), is(2));

        assertThat(course.getCourseName(), is("CS112"));
    }

    @Test 
    public void XLSTGroupConstructorTest() {
        Course course = new Course("31559", "CS", "120G", 30, 1, "B1", "SS167", 30, 1);

        assertThat(course.getCRN(), is("31559"));
        assertThat(course.getSubj(), is("CS"));
        assertThat(course.getCrse(), is("120G"));
        assertThat(course.getXlstCap(), is(30));
        assertThat(course.getEnrollment(), is(1));
        assertThat(course.getLink(), is("B1"));
        assertThat(course.getXlstGroup(), is("SS167"));
        assertThat(course.getOverallCap(), is(30));
        assertThat(course.getOverallEnr(), is(1));

        assertThat(course.getCourseName(), is("CS120G"));

    }
     
}
