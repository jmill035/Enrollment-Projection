package edu.odu.cs.cs350.pne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


//consider changing into SemesterHistory/History class
//the output of current class should be saved in a datastructure(list,etc)
public class IOReader {
    public void beginIOread (String[] args) {
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
        for (File file : files){
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null){
                    String[] values = line.split(","); //some commas are within quotes and faculty name abbreviations. high potential for error, recommend using openCSV
                    for (String value : values) {
                        System.out.print(value + ", ");
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
