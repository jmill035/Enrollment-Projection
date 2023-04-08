package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;

public class OfferingTest {
    
    @Test 
    public void ConstrutorTest(){
        Offering offer = new Offering("SC450", 30, 0);

        assertThat(offer.getXlstGroup(), is("SC450"));
        assertThat(offer.getOverallCap(), is(30));
        assertThat(offer.getOverallEnr(), is(0));

        offer.setXlstGroup("");
        assertFalse(offer.getXlstGroup().contains("SC450"));
        assertThat(offer.getXlstGroup(), is(""));

        offer.setOverallCap(15);
        assertThat(offer.getOverallCap(), not(is(30)));
        assertThat(offer.getOverallCap(), is(15));

        offer.setOverallEnr(15);
        assertThat(offer.getOverallCap(), not(is(0)));
        assertThat(offer.getOverallCap(), is(15));
    }
}

//Calculate the overall cap for all offerings of the course
@Test
public void calculateOverallCapTest() {
 Offering offer1 = new Offering ("CS350", 30, 0);
 Offering offer2 = new Offering ("CS350", 40, 0);
 Offering offer3 = new Offering ("CS350", 50, 0);
 
 List<Offering> offerings = new ArrayList<Offering>();
}
