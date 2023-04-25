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
}    
