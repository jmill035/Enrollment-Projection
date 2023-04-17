package edu.odu.cs.cs350.pne;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class IOReaderTest {
    @Test
    void testReadCSVFiles() {
       // String directoryPath = "src/test/java/edu/odu/cs/cs350/pne/data/summary/History/202230";
        String directoryPath = "src/test/data/summary/History/202230/";
        File directory = new File(directoryPath);
        assertTrue(directory.exists(), "Directory does not exist");
        assertTrue(directory.isDirectory(), "Path is not a directory");

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".csv"));
        assertNotNull(files, "No CSV files found in directory");
        
        for (File file : files){
            try {
                assertTrue(file.canRead(), "Could not read file: " + file.getName());
            } catch (SecurityException e) {
                fail("Security exception while accessing file: " + file.getName());
            }
        }
    }
}


