package edu.odu.cs.cs350.pne;

import java.util.Scanner;

public class TestEnrollementPercentage {

    public static double getEnrollmentPercentage (Enrollement begin, Enrollement end ) {

    Enrollement start = Enrollement.now();

    //Registration end_Date = EndDate.now();

    int EnrollmentPercentage = end.getRegistrationdate() - start.getRegistrationDate();
    //     int EnrollmentPercentage = end.Enrollement/...date() - start.Enrollement/..date();


    double percentage =((double) EnrollmentPercentage) * 100;

    return percentage;
}

 

 System.out.println("Percentage of enrollment period that has passed:" + percentage + "%");

 

}







// function "to supply past & current semester directories in the CLI"