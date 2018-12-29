import java.util.Scanner;
/** 
     *  @author Shuchen Zhang szhan106, 10/01/2018
 */
public class October { 
 /** Main method.      
    *  @param args not used
  */
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.println("Enter a target string:");
      if (scnr.hasNext()) {
         String target = scnr.next();
         target = target.toLowerCase();
         System.out.println("Enter a comparison string:");
         while (scnr.hasNext()) {
            String comparison = scnr.next();
            comparison = comparison.toLowerCase();
            int result = comparison.compareTo(target); 
            if (result > 0) {
               System.out.println(comparison + " is greater than " + target);
            }
            else if (result == 0) {
               System.out.println(comparison + " is equal to " + target);
            }
            else if (result < 0) {
               System.out.println(comparison + " is smaller than " + target);
            }
            else {
               System.out.println("Error.");
            }
            System.out.println("Enter a comparison string:");
            
            
            
         }
         
         
         
      }
      
         
      
      
      
      
   }  
}


   
