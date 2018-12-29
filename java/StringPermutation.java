import java.util.Scanner;

/** A class for string permutations.
    Also reiterates static method definitions and javadoc comments.
*/
public class StringPermutation {
    /** this method checks if two strings are permutations - case insensitive.
       @param s1 string containing letters only
       @param s2 string containing letters only
       @return true if s1 and s2 are permutations, false otherwise.
   */
   public static boolean arePermutations(String s1, String s2) {
      s1 = s1.toLowerCase();
      s2 = s2.toLowerCase();
      for (int i = 0; i < s1.length(); i++) {
         boolean charin = false;
         for (int j = 0; j < s2.length(); j++) {
            
             
               
               
               
         } 
           
        
         
      
      
      
      }
      
      
      return false;
   } 
    
            
    /** Main execution. Reads two strings and calls arePermutations with them.
       @param args not used
   */ 
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.print("Enter a string: ");
      String str1 = scnr.next();
      System.out.print("Enter a 2nd string: ");
      String str2 = scnr.next();
      
      //check if str1 and str2 are permutations or not
      if (arePermutations(str1, str2)) {
         System.out.println("Two strings are permutations!");
      }
      else {
         System.out.println("Two strings are not permutations!");
      } 
   }              
}