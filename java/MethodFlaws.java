/** Examples of debugging methods in jGRASP,
    enabling assertions (Build menu, Enable Assertions)
    for unit testing of methods, and generating
    javadoc documentation (book icon).
*/
public class MethodFlaws {

   /** Main method, execution starts here.
      @param args the unused command line arguments
   */
   public static void main(String[] args) {
   
      int low, high;
   
      System.out.println("testing assertions...");
      //assert false : "testing asserts enabled";
      assert 13 == 39 / 3.0 : "13 != 39/3.0 due to roundoff";
      
      System.out.println("testing method1...");
      low = 1;
      high = 10;
      assert sum(1, 1) == 0 : "sum(x, x) == 0 failed";
      assert sum(low, high) == 45 : "sum(1, 10) == 45 failed";
      assert sum(-5, 5) == -5 : "sum(-5, 5) == -5 failed";
      assert sum(high, low) == 0 : "sum(high, low) == 0 failed";
      
      System.out.println("testing method2...");
      assert invert("a").equals("a") : "invert(\"a\") is \"a\" failed";
      assert invert("abcd").equals("bcad") : 
         "invert(\"abcd\") is \"bcad\" failed";
      assert invert("asdfghjkl").equals("gfhdjskal") : 
         "invert(\"asdfghjkl\") is \"gfhdjskal\" failed";      
      System.out.println("execution finished");
   }
   
   /** Iterative method to compute the sum of a range of integers.
       @param low the low end of the range, inclusive
       @param high the high end of the range, inclusive
       @return the sum, assuming low < high, 0 otherwise
   */
   public static int sum(int low, int high) {
      int sum = 0;
      while (low < high) {
         sum = sum + low;
         low += 1;
      }
      return sum;
   }
   
   /** Recursive method to turn a string inside out.
       For example, "abcd" generates "bcad" and 
       "asdfghjkl" generates "gfhdjskal".
       @param s the string to invert
       @return the inverted string
   */
   public static String invert(String s) {
     //base case
      if(s.length() <= 1) {
         return s;
      }
            
      int mid = s.length() / 2;
      if (s.length() % 2 == 0) { 
         // even length
         // save chars &amp; substrings in variables for debugging
         return "" + s.charAt(mid - 1) + s.charAt(mid) +
            invert(s.substring(0, mid - 1) + s.substring(mid + 1));
      } else { 
         // odd length
         return s.charAt(mid) +
            invert(s.substring(0, mid) + s.substring(mid + 1));
      }
   }
     
}