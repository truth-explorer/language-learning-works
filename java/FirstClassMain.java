/** Demonstration of how methods can change objects
 *  and how to work with an array of class objects.
 *  Also illustrates use of a static class method.
 */
public class FirstClassMain {

   public static void main(String[] args) {
   
      int reps = 3;
      System.out.println("before triple int reps is " + reps);
      triple(reps);
      System.out.println(" after triple int reps is " + reps);
   
      System.out.println("before triple assign int reps is " + reps);
      reps = triple(reps);
      System.out.println(" after triple assign int reps is " + reps);
   
      int[] ra = {2, 4, 6};
      System.out.println("before int triple ra[0] is " + ra[0]);
      triple(ra[0]);
      System.out.println(" after int triple ra[0] is " + ra[0]);
      
      System.out.println("before array triple ra[1] is " + ra[1]);
      triple(ra);
      System.out.println(" after array triple ra[1] is " + ra[1]);
      
      FirstClass one = new FirstClass('j', 3);
      System.out.println("before triple FirstClass one is " + one);
      triple(one);
      System.out.println(" after triple FirstClass one is " + one);
   
      System.out.println("before tripleNew FirstClass one is " + one);
      FirstClass n = tripleNew(one);
      System.out.println(" after tripleNew FirstClass one is " + one);
      System.out.println(" after tripleNew FirstClass n is " + n);
      
      FirstClass[] fcarr = new FirstClass[10];
      fcarr[0] = one;
      fcarr[1] = n;
      fcarr[2] = new FirstClass('*', 5);
      FirstClass.setRepBound(15);
      doRay(fcarr, 3, ra); 
      for (int i = 0; i < 3; i++) {
         System.out.println(fcarr[i]);
      }
      // How many FirstClass objects exist in memory at this point? 
   }

   public static int triple(int n) {
      n = n * 3;
      return n;
   }

   public static void triple(int[] n) {
      for (int i = 0; i < n.length; i++) {
         n[i] = n[i] * 3;
      }
   }

   public static void triple(FirstClass n) {
      n.setReps(n.getReps() * 3);
   } 

   public static FirstClass tripleNew(FirstClass n) {
      FirstClass f = new FirstClass(n.getLet(), n.getReps() * 3);
      n = f;
      return f;
   }
   
   public static void doRay(FirstClass[] fra, int count, int[] ra) {
      for (int i = 0; i < count; i++) {
         fra[i].setReps(ra[i]);
      }
   }
}
