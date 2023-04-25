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
public class DetailedReport {
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

        Map<String, Double> categoryAverages = new HashMap<>();
        
        for (File file : files) {
            String fileName = file.getName();
            String category;
            if (fileName.contains("2023-01") || fileName.contains("2023-02")) {
                category = "Current Enrollment";
            } else if (fileName.contains("2022")) {
                category = "History";
            } else if (fileName.contains("2023-03")) {
                category = "Projected Enrollment";
            } else {
                category = "Unknown";
            }
            double sum = 0.0;
            int count = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length >= 8) {
                        try {
                            double value = Double.parseDouble(values[7]);
                            sum += value;
                            count++;
                        } catch (NumberFormatException e) {
                            // Ignore non-numeric values in column 8
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (count > 0) {
                double average = sum / count;
                // Update the map with the average value for the current category
                categoryAverages.put(category, categoryAverages.getOrDefault(category, 0.0) + average);
            }
        }
        
        // Write the results to an Excel file
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Averages");
            
            // Create a header row
            Row headerRow = sheet.createRow(0);
            Cell categoryHeaderCell = headerRow.createCell(0);
            categoryHeaderCell.setCellValue("Category");
            Cell averageHeaderCell = headerRow.createCell(1);
            averageHeaderCell.setCellValue("Average");
            
            // Add a row for each category
            int rowNum = 1;
            for (String category : categoryAverages.keySet()) {
                double average = categoryAverages.get(category) / files.length;
                Row row = sheet.createRow(rowNum++);
                Cell categoryCell = row.createCell(0);
                categoryCell.setCellValue(category);
                Cell averageCell = row.createCell(1);
                averageCell.setCellValue(average);
            }
            
            // Write the workbook to a file
            File outputFile = new File("averages.xlsx");
            workbook.write(outputFile);
            System.out.println("Results written to " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

