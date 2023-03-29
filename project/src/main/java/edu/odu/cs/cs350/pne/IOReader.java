package edu.odu.cs.cs350.pne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOReader {
    public static void ReadExcelSheets() {
        String[] filepaths = {"project/src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230/*.csv"};
        for (String filepath : filepaths){
            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                String line;
                while ((line = br.readLine()) != null){
                    String[] values = line.split(",");
                    for (String value : values) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

/*
 * original from josh's Main
 */
// public class ReadExcelSheets {
//     public static void main(String[] args) {
//         String filePath = "src/data/test.xlsx";
//         try {
//             FileInputStream inputStream = new FileInputStream(new File(filePath))
//             Workbook workbook = WorkbookFactory.create(inputStream);
//             int numberOfSheets = workbook.getNumberOfSheets();
//             for (int i = 0; i < numberOfSheets; i++;); {
//                 Sheet sheet = workbook.getSheetAt(i);
//                 System.out.println("Sheet Name: " + sheet.getSheetName());
//                 for (Row row : sheet) { 
//                     for (Cell cell : row) {
//                         System.out.print(cell.getStringCellValue() + "\t");
//                     }
//                     System.out.println();
//                 }
//             }
//         }
//         workbook.close();
//         inputStream.close();
//     } catch (IOExceotion e){
//         e.printStackTrace();
//     }
// }
