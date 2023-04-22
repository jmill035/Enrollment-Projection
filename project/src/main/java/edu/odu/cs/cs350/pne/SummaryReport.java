package edu.odu.cs.cs350.pne;
//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.IOException;

public class SummaryReport {

    private char marker;        // represents the projected enrollment
    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String course;
    private int enrollment;
    private int projectedEnrollmentVal;
    private int cap;
    
    public SummaryReport() {
        this.marker = ' ';
    }

    public SummaryReport(String course, int enrollment, int projectedEnrollmentVal, int cap) {
        this.course = course;
        this.enrollment = enrollment;
        this.projectedEnrollmentVal = projectedEnrollmentVal;
        this.cap = cap;
    }

    public String getCourse() {
        return course;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public int getProjectedEnrollmentVal() {
        return projectedEnrollmentVal;
    }

    public int getCap() {
        return cap;
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

        //StringBuilder body = new StringBuilder();
        /*
        for(Course course: courses) {
            body.append(String.format("%-1s"));
            
        }
        */
        return header;
    }


    // public static double getEnrollmentPercentage (Enrollment begin, Enrollment end ) {

    //     Enrollment start = Enrollment.now();

    //     //Registration end_Date = EndDate.now();

    //     int EnrollmentPercentage = end.getRegistrationdate() - start.getRegistrationDate();
    //     //     int EnrollmentPercentage = end.Enrollement/...date() - start.Enrollement/..date();


    //     double percentage =((double) EnrollmentPercentage) * 100;

    //     //this may be where it belongs @Kofi, I moved it accidentally
    //     System.out.println("Percentage of enrollment period that has passed:" + percentage + "%");

    //     return percentage;
    // }

    public void getEnrollmentPercentage(String[] args) throws IOException
    {
        // reads the data.txt file and reads line 1 as pre-reg date and reads 2nd line as deadline date
        ClassLoader cl = getClass().getClassLoader();
        File file1 = new File (cl.getResource("./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/dates.txt").getFile());
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        String preReg = reader.readLine();
        String addDeadline = reader.readLine();
        reader.close();

        // creates instance of date today, converts strings into Date format for pre-reg & deadline
        LocalDate today = LocalDate.now();
        LocalDate preRegDate = LocalDate.parse(preReg, dateFormat);
        LocalDate addDeadlineDate = LocalDate.parse(addDeadline, dateFormat);
        
        // creates a course and adds to list with course name, enrollment, project enrollment, and cap
        List<SummaryReport> courseOfferings = new ArrayList<>();
        courseOfferings.add(new SummaryReport("CS120G", 46, 104, 120));

        // calculates the percentage of the enrollment period that has passed
        int daysPassed = (int) ChronoUnit.DAYS.between(preRegDate, today);
        int totalDays = (int) ChronoUnit.DAYS.between(preRegDate, addDeadlineDate);
        int percentPassed = (int) Math.round(100.0 * daysPassed / totalDays);
        percentPassed = Math.max(percentPassed, 0);
        percentPassed = Math.min(percentPassed, 100);


        // prints the Summary Projection Report header
        System.out.println(percentPassed + "% of enrollment period has elapsed.");
        System.out.printf("%-8s %-10s %-12s %-8s%n", "Marker", "Course", "Enrollment", "Projected");
        
        // calculates the projected enrollment for each course on the add deadline and prints the report
        for (SummaryReport offering : courseOfferings) {
            int currentEnrollment = offering.getEnrollment();
            int daysLeft = (int) ChronoUnit.DAYS.between(today, addDeadlineDate);
            int projectedEnrollment = Math.round(currentEnrollment * ((float) daysLeft / totalDays));
            String marker = (projectedEnrollment > offering.getCap()) ? "*" : " ";
            System.out.printf("%-8s %-10s %-12d %-8d %-8d%n",
                    marker, offering.getCourse(), currentEnrollment, projectedEnrollment, offering.getCap());
        }
    }
}

