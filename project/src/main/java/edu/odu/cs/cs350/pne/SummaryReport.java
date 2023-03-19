package edu.odu.cs.cs350.pne;
import java.util.Scanner;

public class SummaryReport {

    char marker;        // represents the projected enrollment 

    /**
     * If the projected enrollment is greater than the cap, then an 
     * asterisk is returned. Otherwise, a blank space is returned.
     * @param projected the number of students projected to enroll 
     * @param cap the maximum number of students able to enroll
     * @return char for projected enrollment
     */
    public char projectedEnrollment(int projected, int cap) {

        if(projected > cap) {
            return '*';
        }
        else {
            return ' ';
        }

    }

    /**
     * Prints the headers for the summary projection report
     */
    public String toString() {

        String header = String.format("%-1s %-10s %-15s %-15s %-15s", 
                        " ", "Course", "Enrollment", "Projected", "Cap");
        
        // "observable" behavior
        System.out.println(header);

        return header;
    }


    public static double getEnrollmentPercentage (Enrollement begin, Enrollement end ) {

        Enrollement start = Enrollement.now();

        //Registration end_Date = EndDate.now();

        int EnrollmentPercentage = end.getRegistrationdate() - start.getRegistrationDate();
        //     int EnrollmentPercentage = end.Enrollement/...date() - start.Enrollement/..date();


        double percentage =((double) EnrollmentPercentage) * 100;

        //this may be where it belongs @Kofi, I moved it accidentally
        System.out.println("Percentage of enrollment period that has passed:" + percentage + "%");

        return percentage;
    }

}


-------------

