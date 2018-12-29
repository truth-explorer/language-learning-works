import java.util.Scanner;

/** A class for String Encryption.
*/
public class Encryption {
    /** encrypt the string based on the given rules.
       @param str string to be encrypted
       @return str: encrypted version of str
   */
   public static String encrypt(String str) {
      String result = "";
      for (int i = 0; i < str.length(); i++) {
         if (Character.isLetter(str.charAt(i))) {
            if (Character.isLowerCase(str.charAt(i))) {
               if (str.charAt(i) == 'z') {
                  result = result.concat("A");
               }
               else { 
                  result += Character.toUpperCase((char)(str.charAt(i) + 1));
               }   
            }
            else {
               if (Character.isUpperCase(str.charAt(i))) {
                  if (str.charAt(i) == 'Z') {
                     result = result.concat("a");
                  }
                  else { 
                     result += Character.toLowerCase((char)(str.charAt(i) + 1));
                  }  
               
               }
            }
                          
         }
         else if (str.charAt(i) == '~' && i > 0) {
            if (Character.isDigit(str.charAt(i-1))) {
               result = result.concat("/");
            }
            else {
               result += '~';
            }
         }
         else if (str.charAt(i) == '^' && i > 0) {
            if (Character.isDigit(str.charAt(i-1))) {
               result = result.concat("_");
            }
            else {
               result += '^';
            }
         
         }
         else if(Character.isDigit(str.charAt(i))) {
            int num = Character.getNumericValue(str.charAt(i));
            num = (++num) % 10;
            result = result.concat(Integer.toString(num));
         }
         else {
            result += str.charAt(i);
         }
          
      
      
      }
      str = result;
      return str;
   } 
    
            
    /** Main execution.
       @param args not used
   */ 
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.print("Enter a string: ");
      String message = scnr.next();   
      String encrypted = encrypt(message);
      System.out.println(message + " encrypted is: " + encrypted);
      
   }              
}