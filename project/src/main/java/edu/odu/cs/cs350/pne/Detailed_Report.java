package edu.odu.cs.cs350.pne;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Detailed_Report {
    public static void main(String[] args) {
        String inputFile = "input.csv";
        String outputFile = "output.xlsx";

        try{
            BufferedReader reader new BufferedReader(new FileReader(inputFile));
            
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet 1");

            String line;
            int rowNum = 0;

            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");

                XSSFRow row = sheet.createRow(rowNum++);
                int cellNum = 0;
                for (String value : data) {
                    XSSFCell cell = row.createCell(cellNum++);
                    cell.setCellValue(value);
                }
            }
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            workbook.write(outputStream);
            workbook.close();
            System.out.println("Excel file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}