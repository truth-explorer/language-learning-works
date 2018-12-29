/** This is a first class definition to create a new data type.  It's
 *  a fairly simple example, including a main method for testing
 *  convenience.
 */
public class FirstClass {

  /** Shared upper bound on repetitions for all FirstClass objects. */
   private static int bound = 10;

   /** The letter it holds. */
   private char let;
   /** How many repetitions. */
   private int reps;

   /** Create an object with 1 rep as the default.
    * @param c the character value
    */
   public FirstClass(char c) {
      this.let = c;
      this.reps = 1;
   }

   /** Create an object with specified character and reps.
    * @param c the character value
    * @param r the repetitions, must be > 0
    */
   public FirstClass(char c, int r) {
      this.let = c;
      this.setReps(r);
   }

   /** Get the value of the character.
    * @return the character
    */
   public char getLet() {
      return this.let;
   }
   
   /** Get the value of the repetitions.
    * @return the reps
    */
   public int getReps() {
      return this.reps;
   }

   /** Set the value of the repetitions.
    * @param r the new reps value, must be > 0 and < bound
    * otherwise it gets set to 1
    */
   public void setReps(int r) {
      if (r > 0 && r < bound) {
         this.reps = r;
      } else {
         this.reps = 1;
      }
   }

   /** Create a string representation of the object,
       which is the character repeated reps number of times,
       or an empty string if reps is 0.
    * @return the string
    */
   public String toString() {
      String result = "";
      for (int i = 0; i < this.reps; i++) {
         result += this.let;
      }
      return result;
   }
   
   /** Change the upper boundary on number of repetitions.
    *  @param upper the new boundary value
    */
   public static void setRepBound(int upper) {
      if (upper >= 1) {
         bound = upper;
      }
   }

   // this is the end of the data type definition
   
   /** We are putting main here for convenience. 
    *  @param args not used
    */
   public static void main(String[] args) {
   
      FirstClass one = new FirstClass('a');
      FirstClass two = new FirstClass('b', 5);
      FirstClass tre = new FirstClass('c', -10);
   
      System.out.println("one is " + one.toString());
      System.out.println("two is " + two);  
      System.out.println("tre is " + tre + "(empty)");  
      System.out.println("two char is " + two.getLet());
   
      tre.setReps(8);
      System.out.println("updated tre is " + tre);  
      two.setReps(15);
      System.out.println("two is " + two);
      FirstClass.setRepBound(20);
      two.setReps(15);
      System.out.println("updated two is " + two);         
   }

}
