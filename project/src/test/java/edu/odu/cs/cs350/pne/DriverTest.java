package edu.odu.cs.cs350.pne;


import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DriverTest {
    
    @Test
    public void testDriver() {
        String[] args = {"src/test/data/summary/History/202230", "/project/build/tmp/test/", "/project/build/tmp/test/"};
        Driver.main(args);
        List<String[]> data = Driver.getData();
       assertEquals(9, data.size()); // assuming the test data has 9 rows
        //Print the data for verification
        System.out.println(data);
    }
}
