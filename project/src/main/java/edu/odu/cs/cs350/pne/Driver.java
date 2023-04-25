package edu.odu.cs.cs350.pne;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.opencsv.CSVReader;


/*
 * 1) input args: 
 *      pos(1...n): one or more semester directory locations, indicating the locations of historical enrollment data. > input into a list
 *      pos(n-2): A single semester directory location, indicating the enrollment data for the semester for which a projection is desired.
 *      pos(n-1): A path indicating the file location where the detailed projection report will be written.
 *      
 *      --options flag YYYY-MM-DD, indicating the last day on which enrollment data from he semester being projected should be examined.
 * 2) call csv parsing and datastructure obj
 * 3) print summary report
 * 
 * x) Summary Report with header and output
 * 
 * 
 * 
 * 
 */
 public class Driver {
    static List<String[]> data;
    public static List<String[]> getData() {
        return data;
    }


    public static void main(String[] args) {
        String detailedProjectReportOutputLocation = "";
        String currentSemesterProjection = "";
        List<String> semesterDirectories = new ArrayList<>(); // this list is from CLI input. and only directory locations

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
            System.out.print("Enter the directory path for the current semester projection: ");
            Scanner scanner = new Scanner(System.in);
            currentSemesterProjection = scanner.nextLine();

            System.out.print("Enter the file path for the detailed projection report: ");
            detailedProjectReportOutputLocation = scanner.nextLine();
        }

        /*
         * Convert CSV into List object
         * Output is a usable ArrayList for a given CSV. 
         * parameter name: data
         */

        // enrollmentReport is for testing 
        String enrollmentReport = "/test/data/summary/History/202230/2022-12-20.csv";
        try (CSVReader reader = new CSVReader(new FileReader(enrollmentReport))) {
            List<String[]> data = new ArrayList<>();
            String[] line;
            while ((line = reader.readNext()) != null) {
                String[] shortLine = Arrays.copyOf(line, 10);
                data.add(shortLine);
            }
            System.out.println(data);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO: projection calculations
        // Use: List<String[]> data as parameter

    }
}