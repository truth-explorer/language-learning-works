import java.util.Scanner;
public class bus {
   public static void main(String [] args ) {
      int students = 0;
      int buses = 0;
      final int load = 32;
      int firstResult = 0;
      Scanner input = new Scanner(System.in);
      students = input.nextInt();
      students = students + (students / load + 1) * load - students;
      buses = students / load;
      System.out.print(buses);
   }
}
      
      
      
      
        
      
      
