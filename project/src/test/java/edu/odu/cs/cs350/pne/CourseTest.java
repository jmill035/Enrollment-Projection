package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CourseTest {

    Offering offer1;
    Offering offer2;
    
    Section section1;
    Section section2;
    Section section3;

    Course course1;
    Course course2;

    @BeforeEach
    public void setUp () throws Exception {

        offer1 = new Offering("SC450", 30, 7);
        offer2 = new Offering("SC065", 40, 3);

        section1 = new Section("29869", 30, 0);
        section2 = new Section("30065", 15, 0,"P3");
        section3 = new Section("21784", 25, 5 );

        course1 = new Course("CS", "115");
        course2 = new Course("CS", "120");

        section1.addOffering(offer1);
        section2.addOffering(offer2);

        course1.addSection(section1);
        course1.addSection(section2);
        course1.addSection(section3);
    }

    @Test 
    public void ConstructorTest() { 

        assertThat(course1.getSubj(), is("CS"));
        assertThat(course1.getCrse(), is("115"));

        assertThat(course1.getCourseName(), is("CS115"));
    }

    @Test
    public void addSectionTest() {
        
        assertThat(course1.searchSection("29869"), is(section1));
        assertThat(course1.searchSection("30065"), is(section2));
        assertThat(course1.searchSection("21784"), is(section3));

        assertThat(course1.searchSection("29869").getOffering(), is(offer1));
        assertThat(course1.searchSection("30065").getOffering(), is(offer2));
        assertThat(course1.searchSection("21784").getOffering(), is(nullValue()));

        assertThat(course1.searchSection("20083"), is(nullValue()));
    }

    @Test 
    public void CalcOverallEnrTest() {
        
        assertThat(course1.calcOverallEnrollment(), is(10));
        assertThat(course1.calcOverallEnrollment(), not(is(0)));
        assertThat(course1.calcOverallEnrollment(), not(is(7)));
    }

    @Test
    public void CalcOverallCapTest() {

        assertThat(course1.calcOverallCap(), is(70));
        assertThat(course1.calcOverallCap(), not(is(0)));
        assertThat(course1.calcOverallCap(), not(is(30)));
    }
    
}
