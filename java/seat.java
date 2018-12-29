import java.util.Scanner;
import java.util.Random;
public class seat {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String[] names = new String[30];
      String[] seats = new String[15];
      String[] fail = new String[30];
      System.out.println("Your name:");
      int i = 0;
      int occupied1 = 0, occupied2 = 0, occupied3 = 0;
      Random rand = new Random();
      while(scnr.hasNext()) {
         names[i] = scnr.next();
         System.out.println("Which module?");
         int module = scnr.nextInt();
         switch(module) {
            case 1:
               if (occupied1 < 5) { 
                  int num1 = rand.nextInt(5);
                  while (seats[num1] != null) {
                     num1 = rand.nextInt(5);
                  }
                  seats[num1] = names[i];
                  occupied1++;
               }
               else {
                  fail[i] = names[i];
               }
               break;
            case 2:
               if (occupied2 < 5) { 
                  int num2 = rand.nextInt(5) + 5;
                  while (seats[num2] != null) {
                     num2 = rand.nextInt(5) + 5;
                  }
                  seats[num2] = names[i];
                  occupied2++;
               }
               else {
                  fail[i] = names[i];
               }
               break;
            default:
               if (occupied3 < 5) { 
                  int num3 = rand.nextInt(5) + 10;
                  while (seats[num3] != null) {
                     num3 = rand.nextInt(5) + 10;
                  }
                  seats[num3] = names[i];
                  occupied3++;
               }
               else {
                  fail[i] = names[i];
               }
               break;
                
         }
         i++;
         System.out.println("Your name:");
      }
      for (int i = 0; i < seats.length(); i++) {
         System.out.printf("%s sits in seat %d.\n", seats[i], i);
      }
         
   
   
   
   
   
   
   }
}