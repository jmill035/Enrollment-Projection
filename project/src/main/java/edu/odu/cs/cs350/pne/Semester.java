package edu.odu.cs.cs350.pne; 

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException;

public class Semester {

    private Scanner scanner;

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

    //read the first line of dates.txt as pre-reg date and store it in arrayList
    // BufferedReader reader = new BufferedReader(new FileReader("dates.txt"));
    // ArrayList<String> listOfLines = new ArrayList<>();
    // String dateLine = reader.readLine();
    // while (dateLine != null)
    // {
    //     listOfLines.add(dateLine);
    //     dateLine = reader.readLine();
    // }
    // reader.close();

    

    //read the second line of dates.txt as add deadline
    
    //retrieve pre-reg date and add deadline date from arrayList
    
}

}