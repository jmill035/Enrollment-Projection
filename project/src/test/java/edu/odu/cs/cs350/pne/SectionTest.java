package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SectionTest {

    @Test
    public void ConstrutorTest(){
        Section section = new Section("30065", 15, 0);

        assertThat(section.getCRN(), is("30065"));
        assertThat(section.getXlstCap(), is(15));
        assertThat(section.getEnrollment(), is(0));
        assertThat(section.getLink(), is(""));
        assertThat(section.getOffering(), is(nullValue()));

    }

    @Test 
    public void LinkConstructorTest() {
        Section section = new Section("21784", 25, 3, "P3");

        assertThat(section.getCRN(), is("21784"));
        assertThat(section.getXlstCap(), is(25));
        assertThat(section.getEnrollment(), is(3));
        assertThat(section.getLink(), is("P3"));
        assertThat(section.getOffering(), is(nullValue()));
    }

    @Test
    public void addOfferingTest() {
        Section section = new Section("23742", 35, 5, "A1");
        Offering offer = new Offering("SC065", 40, 5);

        assertThat(section.getOffering(), is(nullValue()));

        section.addOffering(offer);

        assertThat(section.getOffering(), not(is(nullValue())));

        assertThat(section.getOffering().getXlstGroup(), is("SC065"));
        assertThat(section.getOffering().getOverallCap(), is(40));
        assertThat(section.getOffering().getOverallEnr(), is(5));
    }
}
