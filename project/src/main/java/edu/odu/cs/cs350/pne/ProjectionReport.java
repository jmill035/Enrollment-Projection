package edu.odu.cs.cs350.pne;

import java.util.List;

public class ProjectionReport {

    private List<Offering> offerings;

    public ProjectionReport(List<Offering> offerings) {
        this.offerings = offerings;
    }
    
    public int calculateOverallCap(){
        int overallCap= 0 ;
        for ( Offering offering : offerings) {
         overallCap += offering.getOverallCap();   
        }
        return overallCap;
    }

    public void deadlineOfRecentSem()
    {
        //
    }
}
