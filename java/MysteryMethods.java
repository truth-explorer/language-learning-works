/** Class to demonstrate method flow of control and documentation.
    Do a hand trace first to determine what each method does,
    adding complete javadoc comments to each method.
    Then run this with the debugger to trace execution.
 */
public class MysteryMethods {


   public static void method1() {  //print hello
      System.out.println("hello");
   }


   public static void method2(String phrase, int cutoff) { 
      method1();                                              //print hello
      if (phrase.length() < cutoff) {
         System.out.println(phrase.toLowerCase());           //output in lowercase if short
      } 
      else {
         phrase = phrase.toUpperCase();                       //output in uppercase if long
         System.out.println(phrase.toUpperCase());
      }
      System.out.println(phrase);                        //different if short, same if long         
   }


   public static int method3(int myInt) {
      myInt = myInt * myInt;               //square
      return myInt;
   }


   public static int method4(double number) {
      int count = 0;                            //integer part of log2(number)
      while (number >= 2) {
         count = count + 1;
         number = number / 2;
      }
      return count;
   }


   public static double method5(int p) {  
      if (p > 0) {                            // 10 ** p if p > 0
         return 10 * method5(p - 1);
      } else if (p < 0) {                   // the reciprocal of 10 ** p if p < 0
         return 1.0 / method5(-p);
      } else {                             // return 1 if p == 0
         return 1;
      }
   }


   public static double method6(int n) {     
      if (n < 3) {
         return 1.0;
      } else {
         return method6(n - 1) + method6(n - 2);   //
      }
   }

   /** Start of execution.
       @param args not used
   */
   public static void main(String[] args) {
   
      int myInt = 4;
      double myDbl;
      String phrase = "Hi, How are you?";
   
      method1();
      method2("Hi!", 4);
      method2(phrase, 8);
   
      myDbl = method3(myInt);
      System.out.println("main myInt after method3: " + myInt);
      System.out.println("main myDbl after method3 assignment: " + myDbl);
      System.out.println("method3(-5) result: " + method3(-5));
   
      method4(10);
      System.out.println("method4(10) is " + method4(10));
      myDbl = 2.5;
      System.out.println("method4(" + myDbl + ") is " + method4(myDbl));
      myDbl = 32;
      myInt = method4(myDbl);
      System.out.println("method4(" + myDbl + ") is " + myInt);
   
      System.out.println("method5(8) " + method5(8));
      System.out.println("method5(3) " + method5(3));
      myInt = -4;
      System.out.println("method5(myInt) " + method5(myInt));
      System.out.println("myInt after method 5 is " + myInt);
   
      myInt = 1;
      while (myInt <= 20) {
         System.out.printf("%.0f ", method6(myInt));
         myInt += 1;
      }
      System.out.println();
      
   } // end of main
} // end of class
