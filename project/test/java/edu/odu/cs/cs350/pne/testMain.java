import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class Main {
    @Test
    public void testReadExcelSheets() {
        String expectedOutput = "Sheet Name: Sheet1/n" +
        "A1\tB1\tC1\t\n" + "A2\tB2\tC2\t\n" +
        "Sheet Name: SHeet2\n" + "A1\tB2\tC2\t\n" +
        "A2\tB2\tC2\t\n";
    String filepath = "src/data/test.xlsx";
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    ReadExcelSHeets.main(new String[]{filePath});
    String actualOutput = outContent.toString();
    assertEquals(expectOutput, actualOutput);
    }
}