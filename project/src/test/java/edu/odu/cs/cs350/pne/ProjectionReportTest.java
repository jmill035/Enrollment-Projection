package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectionReportTest {

//Calculate the overall cap for all offerings of the course
@Test
public void calculateOverallCapTest() {
 Offering offer1 = new Offering ("CS350", 30, 0);
 Offering offer2 = new Offering ("CS350", 25, 0);
 Offering offer3 = new Offering ("CS350", 20, 0);
 
 List<Offering> offerings = new ArrayList<Offering>();

 //add offerings 
 offerings.add(offer1);
 offerings.add(offer2);
 offerings.add(offer3);

ProjectionReport report = new ProjectionReport(offerings);
int overallCap = report.calculateOverallCap();

assertThat(overallCap, is (75));

}

}