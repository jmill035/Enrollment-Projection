package edu.odu.cs.cs350.pne;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 1) input args: 
 *      pos(1...n): one or more semester directory locations, indicating the locations of historical enrollment data. > input into a list
 *      pos(n-2): A single semester directory location, indicating the enrollment data for the semester for which a projection is desired.
 *      pos(n-1): A path indicating the file location where the detailed projection report will be written.
 * 2) outpu Summary Report
 * 3) ...
 * 
 * x) Summary Report with header and output
 * 
 * 
 * 
 * 
 */

 public class Driver {
     public static void main(String[] args) {
        String detailedProjectReportOutputLocation = "";
        String currentSemesterProjection = "";
        List<String> semesterDirectories = new ArrayList<>();

        int numArgs = args.length;
        if (numArgs > 2) {
            detailedProjectReportOutputLocation = args[numArgs - 1];
            currentSemesterProjection = args[numArgs - 2];

            for (int i = 0; i < numArgs - 2; i++) {
                semesterDirectories.add(args[i]);
            }
        }

        System.out.println("Historical Semester Directories: " + semesterDirectories);
        System.out.println("Detailed Projection Report will be written to: " + detailedProjectReportOutputLocation);
        System.out.println("Current Semester Projection directory: " + currentSemesterProjection);
        

         // Prompt user to enter input if no arguments were provided
         if (numArgs == 0) {
             Scanner scanner = new Scanner(System.in);
 
             System.out.print("Enter the directory path for the current semester projection: ");
             currentSemesterProjection = scanner.nextLine();
 
             System.out.print("Enter the file path for the detailed projection report: ");
             detailedProjectReportOutputLocation = scanner.nextLine();
         }
 
         // TODO: projection calculations
     }
 }
 
