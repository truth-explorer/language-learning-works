import java.util.Scanner;

/** Skeleton for the heat transfer in a rod.
 */
public class HeatRodSkeleton {

   /** Compare two values to see whether they are
    *  within some epsilon value of each other.
    *  @param value1 one value to be compared
    *  @param value2 the other value
    *  @param epsilon the difference to use
    *  @return true if the difference is less than epsilon, false otherwise 
    */
   public static boolean same(float value1, float value2, double epsilon) {
      if (Math.abs(value1 - value2) < epsilon) {
         return true;
      }
       
      return false;
   }

    /** Compare two arrays of values to see whether they are
    *  equivalent, meaning that each corresponding pair of elements
    *  is within some epsilon value of each other.
    *  @param array1 one array to be compared
    *  @param array2 the other array to be compared
    *  @param epsilon the epsilon value to use
    *  @return true if they are pair-wise less than epsilon, false otherwise 
    */
   public static boolean equivalent(float[] array1, float[] array2, double epsilon) {
      for (int i = 0; i < array1.length; i++) {
         if (!same(array1[i], array2[i], epsilon)) {
            return false;
         }
      }
      return true;
   
   }

    /** Print an array nicely formatted.
     *  @param ra the array to print
     */
   public static void printRA(float[] ra) {
   
      for (int i = 0; i < ra.length; i++) {
         System.out.printf("%8.3f", ra[i]);
      }
      System.out.println();
   }
   

   /** Start of all computation.
    *  @param args not used
    */
   public static void main(String[] args) {
   
      Scanner keys = new Scanner(System.in);
      float cool, hot;
      int segments;
      int i;
      final double eps = 0.01;
   
      System.out.print("Enter cool and hot temperatures: ");
      cool = keys.nextFloat();
      hot = keys.nextFloat();
      System.out.print("What is the rod length? ");
      segments = keys.nextInt();
      
      float[] prev = new float[segments];  
      float[] curr = new float[segments];
      prev[0] = cool;
      curr[0] = cool;
      prev[segments - 1] = hot;
      curr[segments - 1] = hot;
      System.out.println("Temperature distribution simulation:");
      for (int j = 0; j < segments; j++) {
         System.out.print(prev[j] + " ");
      }
      System.out.println();
      System.out.print(curr[0] + " ");
      for (i = 1; i <= segments - 2; i++) {
         curr[i] = (prev[i - 1] + prev[i + 1]) / 2.0f;
         System.out.print(curr[i] + " ");
      }
      System.out.println(curr[segments - 1] + " ");
      while (!equivalent(prev, curr, eps)) {
         System.out.print(curr[0] + " ");
         for (i = 1; i <= segments - 2; i++) { 
            prev[i] = curr[i];
            if (i >=2) {
               curr[i] = (prev[i - 1] + prev[i + 1]) / 2.0f;
               System.out.print(curr[i] + " "); 
            }
            
         }
         System.out.println(curr[segments - 1] + " ");
         
         
      } 
      
      
        
            
         
   }
}
