import java.util.Scanner;
public class weeklypay {   
   public static void main(String[] args){
      System.out.println("Please enter your working hours:");
      Scanner scnr = new Scanner(System.in);
      int workinghours;
      workinghours = scnr.nextInt();
      System.out.println("Please enter your wage:");
      double wage;
      wage = scnr.nextDouble();
      double grosspay = workinghours * wage;
      double parkingfee = 3.50;
      double afterparking = grosspay - parkingfee;
      double tax = afterparking * 0.16;
      double result = afterparking - tax;
      System.out.println("Your gross pay is $" + grosspay);
      System.out.println("But you have to pay $3.50 parking fee.");
      System.out.println("Now you have $" + afterparking);
      
      
      
      
   } 

} 