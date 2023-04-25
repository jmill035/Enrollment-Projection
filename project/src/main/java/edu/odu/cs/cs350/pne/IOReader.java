package edu.odu.cs.cs350.pne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//consider changing into SemesterHistory/History class
//the output of current class should be saved in a datastructure(list,etc)
public class IOReader {
    public void beginIOread(String[] args){
        String directoryPath = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary";
        File directory = new File(directoryPath);
        if (!directory.exists() || !directoryPath.isDirectory()) {
            System.out.println("Directory does not exist or is not a directory");
            return;
        }
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".csv"));
        if (files == null) {
            System.out.println("No CSV files found in directory");
            return;
        }
        
    }
}

