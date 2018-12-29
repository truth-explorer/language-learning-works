import java.util.Random;

/** Demo program for generating different type of random values.
    Also illustrates static method definitions and javadoc comments.
*/
public class RandomHelper {

   /** Class-wide data can be used in any method.
       This is good for variables that should only be
       initialized once when declared.
   */
   public static Random mandy = new Random();

   /** Main execution.
       @param args not used
   */
   public static void main(String[] args) {
   
      Random randy = new Random();  // get different sequences with each run
      Random testy = new Random(6); // get same sequence of random values
      
      int count = 0;
      while (count < 20) {
         System.out.printf("%c %5d  %10.6f   %s\n", randLower(randy),
            randInt(testy, -5, 20), randFloat(-5, 20), randTime());
         count += 1;
      }
   }


// Note the javadoc comments for all these methods!

   /** Generate a random lower case letter.
       @param r the random generator to use
       @return the letter generated
   */
   public static char randLower(Random r) {
      int ran = r.nextInt(26) + 97;
      // TODO: update this method so that it returns
      // a randomly chosen lower case letter 'a' to 'z'
      return (char)ran;
   }


   /** Generate a random integer between low and high, assuming low <= high.
       @param r the random generator to use
       @param low the low value of the range, inclusive
       @param high the upper bound of the range, exclusive
       @return the value generated
   */
   public static int randInt(Random r, int low, int high) {
      int ran = r.nextInt(high - low + 1);
      ran += low;
      // TODO: update this method so that it returns
      // a value in the expected range
      return ran;
   }


   /** Generate a random float between low and high.
       @param low the low value of the range, inclusive
       @param high the upper bound of the range, exclusive
       @return the value generated
   */
   public static float randFloat(int low, int high) {
      // TODO: if high and low are out of order, fix them
      int temp = 0;
      if (low > high) {
         temp = low;
         low = high;
         high = temp;
      }
        
      float num = 0;
      num = mandy.nextFloat();
      int length = high - low + 1;
      num = length * num + low;
      
      // TODO: use global variable mandy to generate a
      // value in the correct range, store in num
      
      return num;
   }


   /** Generate a random standard time of day.
       @return the time of day, such as 8:04pm
       formatted with exactly 2 digits after the colon
   */
   public static String randTime() {
      String time = "";
      int hour = mandy.nextInt(24);
      int decMin = mandy.nextInt(6);
      int min = mandy.nextInt(10);
      
      if (hour == 0) {
         time = String.format("%d:%d%dam", hour + 12, decMin, min);
      }
      else if (hour < 12) {
         time = String.format("%d:%d%dam", hour, decMin, min);
      }
      else if (hour == 12) {
         time = String.format("%d:%d%dpm",hour,decMin,min);
      }
      else {
         time = String.format("%d:%d%dpm",hour-12,decMin,min);
      }
      
      // TODO: edit code to return a random time
      // of day (using mandy), properly formatted
      // using String.format
      
      return time;
   }

}
