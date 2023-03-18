package edu.odu.cs.cs350.pne;

public class SemesterReport {

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
}