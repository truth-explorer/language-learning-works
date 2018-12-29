import java.util.Random;
/** Method to add 5 to the value located at a random location in an array and divide the whole result by 2.


@param rand_val random generator to generate random locations in the array

@param array_vals an array already initialized with 15 ints

@return the value created by the calculation

*/
public class array {
  
   public static int randomarray(Random rand_val, int [ ] array_vals) {
   
   int index = rand_val.nextInt(15);
   array_vals [index] = (array_vals [index] + 5) / 2; 
   return array_vals[index];

   } 
   public static void main(String[] args) {
   Random rand = new Random();

   }
}
 