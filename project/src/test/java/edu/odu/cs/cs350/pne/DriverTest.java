package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

class DriverTest {

    @Test
    void testDriver() {
        String[] args = {
            "src/test/data/summary/History/202230",
            "/project/build/tmp/test/",
            "/project/build/tmp/test/"
        };

        Driver.main(args);
    }
}