package edu.odu.cs.cs350.pne;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SummaryReport {
 
    private List<Course> courses;

    public SummaryReport() {
        this.courses = new ArrayList<>();
    }

    
    public void addCourse(Course course) {
        this.courses.add(course);
    }
    
    public char getMarker(int projected, Course course) {

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
            body.append(String.format("%-1s", getMarker(0, course)));
            body.append(String.format("%-10s", course.getCourseName()));
            body.append(String.format("%-15d", course.calcOverallEnrollment()));
            //body.append(String.format("%-15d", ));
            body.append(String.format("%-15d", course.calcOverallCap()));
        }

        return body.toString();
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

