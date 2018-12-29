import java.util.Scanner;
public class leapyear {
   public static int findNextLeap(int current) {
      while (!(isLeap(current))) {
         current += 1;
      }
      return current;
   }
   public static boolean isLeap(int year) {
      boolean leap = false;
      if (year % 4 == 0) {
         if((year % 100) != 0 || (year % 400) == 0) {
            leap = true;
         }
      }
      return leap;
   }

       
       
   public static void main(String[] args) {
      int currentYear = 0;
      int num = 0;
      Scanner scnr = new Scanner(System.in);
      System.out.println("Please enter the current year:");
      currentYear = scnr.nextInt();
      System.out.println("How many leap years do you want?");
      num = scnr.nextInt();
      if (isLeap(currentYear)) {
         for(int n = num;n>0;n--) {
            if(isLeap(currentYear)) 
               System.out.print(currentYear + " ");
            currentYear += 4;
         }
      }
      else {
         currentYear = findNextLeap(currentYear);
         for(int n = num;n>0;n--) {
            if(isLeap(currentYear)) 
               System.out.print(currentYear + " ");
            currentYear += 4;
         }
      }
   }
}
            
        
              
          
      
