import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class salary {
   public static void main(String[] args) throws IOException {
      FileInputStream input = null;
      Scanner scnr = null;
      input = new FileInputStream("patients.txt");
      scnr = new Scanner(input);
      int[] doctors = new int[120];
      int i = 0;
      while (scnr.hasNext()) {
         doctors[i++] = scnr.nextInt();
      }
      input.close();
      int j = 0;
      
   
   
   
   
   
   
   
   
   
   
   }


}