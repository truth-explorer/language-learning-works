import java.util.Scanner;
public class wednesday {
   public static void main (String[] args) {
      String part;
      Scanner scnr = new Scanner(System.in);
      System.out.println("Which part?");
      part = scnr.next();
      if (part.equals("A") || part.equals("a")) {
         String str = scnr.next();
         int num1 = scnr.nextInt();
         while (num1 < 1) {
            System.out.println("Please enter a valid number:");
            num1 = 0;
            num1 = scnr.nextInt();
         }
      
         int num2 = scnr.nextInt();
         while (num2 > 0) {
            System.out.print(str.substring(0, num1));
            num2 -= 1;
         }
      }
      else if (part.equals("B") || part.equals("b")) {
         int i = 4;
         int a = 1;
         int b = 1;
         int c = 0;
         System.out.print(a + " ");
         System.out.print(b + " ");
         while (i > 0) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
            i -= 1;
         }
      }
      else if(part.equals("c") || part.equals("C")) {
         System.out.println("How many terms do you want?");
         int i = scnr.nextInt()-2;
         int a = 1;
         int b = 1;
         int c = 0;
         System.out.print(a + " ");
         System.out.print(b + " ");
         while (i > 0) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
            i -= 1;
         }
      }
      else if(part.equals("d") || part.equals("D")) {
         System.out.println("How many terms do you want?");
         int i = scnr.nextInt()-2;
         if (i > 40) 
            i = 40;
         int a = 1;
         int b = 1;
         int c = 0;
         System.out.print(a + " ");
         System.out.print(b + " ");
         while (i > 0) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
            i -= 1;
         }
      }
      else {
         System.out.println("Please enter a valid value:");
         part = scnr.next();
      }
      
   }
         
         
           
              
              
      
      
      
}
         

   
      
        
