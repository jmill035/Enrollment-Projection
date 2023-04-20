package edu.odu.cs.cs350.pne;

import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class Detailed_ReportTest {
    @Test
    public void testCVSToExcelConversion() throws Exception {

        String inputFile = "input.csv";
        String outputFile = "output.csv";
        String[] expectedHeader = {"Name", "Age", "City"};
        String[][] expectedData = {{"John Doe", "30", "New York"}
        {"Jane Smith", "24", "Las Vegas"}};

        Detailed_Report.main(new String[] {});

        XSSFWorkbook workbook = new XSSFWorkbook(outputFile);
        Sheet sheet = workbook.getSheetAt(0);
        Row headerRow = sheet.getRow(0);
        for (int i = 0; i < expectedHeader.length; i++){
            Cell cell = headerRow.getCell(i);
            assertEquals(expectedHeader[i], cell.getStringCellValue());
        }
        for (int i = 0; i < expectedData.length; i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < expectedData[i].length; j++){
                Cell cell = row.getCell(j);
                assertEquals(expectedData[i][j], cell.getStringCellValue());
            }
        }
        workbook.close();
    }
}
