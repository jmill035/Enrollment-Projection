package edu.odu.cs.cs350.pne;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class DetailedReport {
    public void writeExcel(String[] args) {
        try (// Create a workbook and a sheet
        Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Enrollment Data");

            // Create a header row
            Row headerRow = sheet.createRow(0);
            String[] columns = {"Category", "File Name", "Average of Column 8"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Initialize the directory and file filters
            String directoryPath = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230";
            File directory = new File(directoryPath);
            if (!directory.exists() || !directory.isDirectory()) {
                System.out.println("Directory does not exist or is not a directory");
                return;
            }
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".csv"));
            if (files == null) {
                System.out.println("No CSV files found in directory");
                return;
            }

            // Process each file in the directory
            int rowNumber = 1;
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

                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    int sum = 0;
                    int count = 0;
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(",");
                        if (values.length >= 8) {
                            try {
                                int value = Integer.parseInt(values[7]);
                                sum += value;
                                count++;
                            } catch (NumberFormatException e) {
                                // Ignore non-integer values
                            }
                        }
                    }
                    double average = (count > 0) ? (double) sum / count : 0;

                    // Create a new row in the sheet and fill in the data
                    Row row = sheet.createRow(rowNumber++);
                    Cell categoryCell = row.createCell(0);
                    Cell fileNameCell = row.createCell(1);
                    Cell averageCell = row.createCell(2);
                    categoryCell.setCellValue(category);
                    fileNameCell.setCellValue(fileName);
                    averageCell.setCellValue(average);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Write the workbook to an output stream
            File outputFile = new File("output.xlsx");
            try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


