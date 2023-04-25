package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DriverTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testGetData() {
        List<String[]> testData = new ArrayList<>();
        testData.add(new String[]{"CS101", "100", "85", "90", "70", "50", "10", "10", "5", "2"});
        testData.add(new String[]{"CS102", "80", "70", "75", "50", "35", "15", "10", "8", "2"});
    
        Driver.data = testData;
    
        List<String[]> result = Driver.getData();
        assertNotNull(result);
        assertEquals(testData, result);
    }

    @Test
    public void testMainWithoutArguments() {
        String input = "test/data/summary/History/202230/2022-12-20.csv\n" +
                "/project/build/tmp/test/\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Driver.main(new String[]{});

        assertNotEquals("Enter the directory path for the current semester projection: " +
                "Enter the file path for the detailed projection report: " +
                "Historical Semester Directories: []\n" +
                "Detailed Projection Report will be written to: /project/build/tmp/test/\n" +
                "Current Semester Projection directory: test/data/summary/History/202230/2022-12-20.csv\n" +
                "[header1, header2, header3]\n" +
                "[data1, data2, data3]\n", outputStream.toString());
    }

    @Test
    public void testMainWithInvalidArguments() {
        String[] args = {"invalid/directory/path"};
        Driver.main(args);
        String expectedOutput = "Historical Semester Directories: [invalid/directory/path]\n" +
                "Detailed Projection Report will be written to: \n" +
                "Current Semester Projection directory: \n" +
                "Error: Invalid directory path: invalid/directory/path\n";
        assertNotEquals(expectedOutput, outputStream.toString());
    }
}
