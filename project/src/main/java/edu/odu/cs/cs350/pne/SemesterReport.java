package edu.odu.cs.cs350.pne;

public class SemesterReport {

    char marker;

    public char projectedEnrollment(int projected, int cap) {

        if(projected > cap) {
            return '*';
        }
        else {
            return ' ';
        }

    }

    public String toString() {

        String header = String.format("%-1s %-10s %-15s %-15s %-15s", 
                        " ", "Course", "Enrollment", "Projected", "Cap");
        
        return header;
    }
}