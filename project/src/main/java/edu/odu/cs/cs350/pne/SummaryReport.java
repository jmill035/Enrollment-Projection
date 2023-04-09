package edu.odu.cs.cs350.pne;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SummaryReport {

    private char marker;        // represents the projected enrollment
    
    public SummaryReport() {
        this.marker = ' ';
    }
    
    /**
     * If the projected enrollment is greater than the cap, then an 
     * asterisk is returned. Otherwise, a blank space is returned.
     * @param projected the number of students projected to enroll 
     * @param cap the maximum number of students able to enroll
     * @return char for projected enrollment
     */
    public char projectedEnrollment(int projected, int cap) {

        if(projected > cap) {
            marker = '*';
        }
        else {
            marker = ' ';
        }

        return marker;

    }

    public char getMarker() {
        return marker;
    }
    /**
     * Prints the headers for the summary projection report
     */
    public String toString() {

        String header = String.format("%-1s %-10s %-15s %-15s %-15s", 
                        " ", "Course", "Enrollment", "Projected", "Cap");

        StringBuilder body = new StringBuilder();
        /*
        for(Course course: courses) {
            body.append(String.format("%-1s"));
            
        }
        */
        return header;
    }


    public static double getEnrollmentPercentage (Enrollment begin, Enrollment end ) {

        Enrollment start = Enrollment.now();

        //Registration end_Date = EndDate.now();

        int EnrollmentPercentage = end.getRegistrationdate() - start.getRegistrationDate();
        //     int EnrollmentPercentage = end.Enrollement/...date() - start.Enrollement/..date();


        double percentage =((double) EnrollmentPercentage) * 100;

        //this may be where it belongs @Kofi, I moved it accidentally
        System.out.println("Percentage of enrollment period that has passed:" + percentage + "%");

        return percentage;
    }

}

