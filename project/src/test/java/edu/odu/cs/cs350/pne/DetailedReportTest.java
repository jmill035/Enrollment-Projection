package edu.odu.cs.cs350.pne;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

public class DetailedReportTest {

    @Test
    public void testWriteExcel() {
        // Prepare input arguments
        String[] args = {};

        // Run the method under test
        DetailedReport detailedReport = new DetailedReport();
        detailedReport.writeExcel(args);

        // Check that the output file was created
        File outputFile = new File("output.xlsx");
        assertTrue(outputFile.exists());

        // Clean up the output file
        outputFile.delete();
    }

    @Test
    public void testWriteExcelWithInvalidDirectory() {
        // Prepare input arguments with an invalid directory path
        String[] args = {"./invalid/path"};

        // Run the method under test
        DetailedReport detailedReport = new DetailedReport();
        detailedReport.writeExcel(args);

        // Check that the output file was not created
        File outputFile = new File("output.xlsx");
        assertFalse(outputFile.exists());
    }

    // Add more test cases as needed for different scenarios and edge cases
}