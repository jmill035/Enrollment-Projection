package edu.odu.cs.cs350.pne;

public class IOReader {
    public static void ReadExcelSheets(String[] args) {
        String filePath = "src/data/test.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(new File(filePath))
            Workbook workbook = WorkbookFactory.create(inputStream);
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++;); {
                Sheet sheet = workbook.getSheetAt(i);
                System.out.println("Sheet Name: " + sheet.getSheetName());
                for (Row row : sheet) { 
                    for (Cell cell : row) {
                        System.out.print(cell.getStringCellValue() + "\t");
                    }
                    System.out.println();
                }
            }
        }
        workbook.close();
        inputStream.close();
    } catch (IOExceotion e){
        e.printStackTrace();
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
