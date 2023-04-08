package edu.odu.cs.cs350.pne;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.File;
//import java.util.Scanner;
//import java.io.FileNotFoundException; 
import java.io.FileReader; 
//import java.io.IOException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;




public class Semester {

    private Scanner scanner;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Semester() {
        scanner = new Scanner(System.in);
    }

public void supplyDirectories (String pastDirectory, String currentDirectory) {

    //Get directory paths from user Input in CLI
    System.out.print("Enter path to past directory: ");
    pastDirectory = scanner.nextLine();

    System.out.print("Enter path to current directory: ");
    currentDirectory = scanner.nextLine();

    System.out.println(pastDirectory);
    System.out.println(currentDirectory);

}

/*
to supply a cutoff date beyond which snapshot date is ignored
each semester directory will contain a file named dates.txt with two specific dates:
one for first day of pre-reg and one for after the add deadline.
this function will ignore any dates BEFORE the pre-reg date and any AFTER the add deadline.
*/

//2022-10-31....2023-05-17
public void supplyCutoff (String args[]) throws Exception
    {
        //grabs the dates.txt file from sample data
        ClassLoader cl = getClass().getClassLoader();
        File file1 = new File (cl.getResource("./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/dates.txt").getFile());

        //read the first line of dates.txt as preReg date and second line as addDeadline date
        BufferedReader reader = new BufferedReader(new FileReader(file1));
    
        //store first date into preReg and store second date into addDeadline
        String preReg = reader.readLine();
        String addDeadline = reader.readLine();
    
        reader.close();

        Date preRegDate = dateFormat.parse(preReg);
        Date addDeadlineDate = dateFormat.parse(addDeadline);

        //read csv files in the sample data and sort them only by files ending in .csv
        String csvPath = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230";
        File csvFolder = new File (csvPath);
        File[] fileArray = csvFolder.listFiles();
        List<String> csvFiles= new ArrayList<String>();
        for (int i = 0; i < fileArray.length; i++)
        {
            if (fileArray[i].isFile())
            {
                String fileName = fileArray[i].getName();
                if(fileName.endsWith(".csv"))
                {
                    csvFiles.add(fileName);
                }
            }
        }
        for (String fileName : csvFiles)
        {
            //store all .csv files, and then ignore dates outside of prereg and addDeadline
            List <LocalDate> dates = preRegDate.datesUntil(addDeadlineDate).collect(Collectors.toList());
        }
    }
}
