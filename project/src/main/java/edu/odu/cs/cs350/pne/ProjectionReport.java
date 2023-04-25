package edu.odu.cs.cs350.pne;

import java.util.Date;
import java.util.List;

public class ProjectionReport {

    private List<Offering> offerings;
    private List<Integer> enrollmentData;

    public void DetailedProjectionReport(List<Offering> offerings, List<Integer> enrollmentData) {
        this.offerings = offerings;
        this.enrollmentData = enrollmentData;
    }
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
    public void generateEnrollmentGraph() {
        System.out.println("Enrollment Graph for this Semester:");
        for (int i = 0; i < enrollmentData.size(); i++) {
            System.out.print("Week " + (i + 1) + ": ");
            for (int j = 0; j < enrollmentData.get(i); j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public void printDetailedReport() {
        System.out.println("Detailed Projection Report:");
        System.out.println("=============================");
        System.out.println("Overall Capacity: " + calculateOverallCap());
        System.out.println("Enrollment Data: " + enrollmentData.toString());
        generateEnrollmentGraph();
    }
}
