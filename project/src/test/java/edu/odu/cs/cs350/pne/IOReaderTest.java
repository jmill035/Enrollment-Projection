package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IOReaderTest {
    private static IOReader reader;
    private static String directoryPath;

    @BeforeAll
    static void setup(){
        reader = new IOReader();
        directoryPath = "./project/src/test/java/edu/odu/cs/cs350/pne/data/summary";
    }

    @Test
    void testFileNotFound(){
        String path = directoryPath + "/History/202230/invalid_directory";
        Assertions.assertThrows(IOException.class, () -> reader.calculateAverages(path));
    }

    @Test
    void testCalculateAverages() throws IOException { 
        String path = directoryPath + "/History/202230";
        String outputFilePath = "./test_output.xlsx";
        reader.calculateAverages(path, outputFilePath);

        Assertions.assertTrue(Files.exists(Paths.get(outputFilePath)));

        String expectedOutput = "Current Enrollment\t40.0\n" + "History\t55.0\n";
        String actualOutput = new String(Files.readAllBytes(Paths.get(outputFilePath)));
        Assertions.assertEquals(expectedOutput, actualOutput);

        File outputFile = new File(outputFilePath);
        outputFile.delete();
    }
}    
