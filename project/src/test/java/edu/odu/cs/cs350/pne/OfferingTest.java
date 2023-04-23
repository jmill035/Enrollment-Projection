package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OfferingTest {
    
    @Test 
    public void ConstrutorTest(){
        Offering offer = new Offering("SC450", 30, 0);
        assertThat(offer.getXlstGroup(), is("SC450"));
        assertThat(offer.getOverallCap(), is(30));
        assertThat(offer.getOverallEnr(), is(0));

        Offering offer2 = new Offering("", 25, 2);
        assertFalse(offer2.getXlstGroup().contains("SC450"));
        assertThat(offer2.getXlstGroup(), is(""));

        Offering offer3 = new Offering("SC451", 15, 2);
        assertThat(offer3.getOverallCap(), not(is(30)));
        assertThat(offer3.getOverallCap(), is(15));

        Offering offer4 = new Offering("SC451", 15, 15);
        assertThat(offer4.getOverallCap(), not(is(0)));
        assertThat(offer4.getOverallCap(), is(15));
    }

    @Test 
    public void GetXLSTTest() {
        Offering offer = new Offering("SC450", 30, 0);

        assertThat(offer.getXlstGroup(), is("SC450"));
        assertThat(offer.getXlstGroup(), not(is(" ")));
    }

    @Test
    public void GetOverallCapTest() {
        Offering offer = new Offering("SC450", 30, 0);

        assertThat(offer.getOverallCap(), is(30));
        assertThat(offer.getOverallCap(), not(is(0)));
        assertThat(offer.getOverallCap(), not(is(15)));
    }

    @Test
    public void GetOverallEnrTest() {
        Offering offer = new Offering("SC450", 30, 0);

        assertThat(offer.getOverallEnr(), is(0));
        assertThat(offer.getOverallEnr(), not(is(30)));
        assertThat(offer.getOverallEnr(), not(is(15)));
    }
}