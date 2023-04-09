package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;


public class EnrollmentTest {

    @Test
    void testDoIt() {
        String inputString = "input\n";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());

        Enrollment enrollment = new Enrollment();
        enrollment.doIt(inputStream, new String[]{"arg1", "arg2"});

        // add assertions for doIt method
        // Check IOReader class was called with the correct arguments
    }
}