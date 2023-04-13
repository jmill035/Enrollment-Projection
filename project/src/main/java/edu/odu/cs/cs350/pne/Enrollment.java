package edu.odu.cs.cs350.pne;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/*
 * 1) input args
 * 2) IOReader process args input
 * 3) ...
 * 
 * x) Summary Report with header and output
 * 
 * 
 * 
 * 
 */

 public class Enrollment {

  /**
   * Main program for Enrollment
   *
   * @param args command line (CLI) parameters
   * @throws IOException when file named in command line cannot be read
   */
  public static void main(String[] args) throws IOException {
      if (args.length == 0) {
          new Enrollment().doIt(System.in, args);
      } else {
          InputStream in = new FileInputStream(new File(args[0]));
          new Enrollment().doIt(in, args);
      }
  }

  /**
   * doIt should implement the command line arguments for both Detailed_Report.java and Summary_Report.java
   *
   */
  public void doIt(InputStream in, String[] args) {
      IOReader.beginIOread(args);
  }

public int getRegistrationdate() {
    return 0;
}
}

