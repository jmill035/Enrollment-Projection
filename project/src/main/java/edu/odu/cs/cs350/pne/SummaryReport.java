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
 
    private List<Course> courses;

    private char marker;        // represents the projected enrollment
    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String course;
    private int enrollment;
    private int projectedEnrollmentVal;
    private int cap;
    
    public SummaryReport() {
        this.courses = new ArrayList<>();
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
    
    public void addCourse(Course course) {
        this.courses.add(course);
    }
    
    public char getEnrMarker(int projected, Course course) {

        if(projected > course.calcOverallCap()) {
            return '*';
        }
        else {
            return ' ';
        }
    }

    /**
     * Prints the summary projection report
     */
    public String toString() {
        StringBuilder body = new StringBuilder();

        // first header
        //body.append().append("\n");

        body.append(String.format("%-1s %-10s %-15s %-15s %-15s", 
                        " ", "Course", "Enrollment", "Projected", "Cap"));
    
        for(Course course : courses) {
            // need to implement projected
            body.append(String.format("%-1s", getEnrMarker(0, course)));
            body.append(String.format("%-10s", course.getCourseName()));
            body.append(String.format("%-15d", course.calcOverallEnrollment()));
            //body.append(String.format("%-15d", ));
            body.append(String.format("%-15d", course.calcOverallCap()));
        }

        return body.toString();
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

    public void getEnrollmentProjection(String[] args) throws IOException
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
        System.out.println(courseOfferings.get(0).toString());

        // calculates the projected enrollment for each course on the add deadline and prints the report
        for (SummaryReport offering : courseOfferings) {
            int currentEnrollment = offering.getEnrollment();
            int daysLeft = (int) ChronoUnit.DAYS.between(today, addDeadlineDate);
            int projectedEnrollment = Math.round(currentEnrollment * ((float) daysLeft / totalDays));
            String marker = (projectedEnrollment > offering.getCap()) ? "*" : " ";
            System.out.println(marker + " " + offering.toString());
        }
    }
}

