import java.io.*;

public class Test{
   public static void main(String args[] ) throws IOException {
      FileOutputStream txt = new FileOutputStream("test.txt");
      PrintWriter result = new PrintWriter(txt);
      result.print("Hello");
      result.flush();
      txt.close();
   
   }
}