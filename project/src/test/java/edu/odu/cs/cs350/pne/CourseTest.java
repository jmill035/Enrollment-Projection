package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CourseTest {

    @Test 
    public void ConstructorTest() {
        Course course = new Course("CS", "115");

        assertThat(course.getSubj(), is("CS"));
        assertThat(course.getCrse(), is("115"));

        assertThat(course.getCourseName(), is("CS115"));
    }

     @Test
     public void addSectionTest() {
        Course course = new Course("CS", "115");

        Section section1 = new Section("29869", 30, 0);
        Section section2 = new Section("30065", 15, 0,"P3");

        Offering offer = new Offering("SC450", 30, 0);

        assertThat(course.getSection("29869"), is(nullValue()));
        
        course.addSection(section1);
        assertThat(course.getSection("29869"), is(section1));
        

        assertThat(course.getSection("30065"), is(nullValue()));
        
        section2.addOffering(offer);
        course.addSection(section2);
        assertThat(course.getSection("30065"), is(section2));
        assertThat(course.getSection("30065").getOffering(), is(offer));


     }

    
}
