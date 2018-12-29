import java.util.Scanner; //So we can collect input from the user


/** This class will be used to create MadLibs and also explore I/O and String operations.
*/
public class MadLibs {
				
   /** This is the main method.
        @param args the command-line arguments, ignored				
   */
   public static void main(String[] args) {
   // Prepare a Scanner object to receive input from keyboard
      Scanner keyboard = new Scanner(System.in);
   
      // Ask user to enter a person’s first name
      System.out.println("May I know your age?");
      int age = keyboard.nextInt();
      System.out.println("Your age is " + age +" ,right?");
      System.out.println("Please enter a name:");
   	
      // Collect text entered by user until user types space or return
      String name = keyboard.nextLine();
   
      // Echo back the collected value, with a label
      System.out.print("You typed in the first name ");
      System.out.print(firstName);
      System.out.println(".");
      System.out.println("Enter a color, food, animal:");// ADD CODE HERE
      String color = keyboard.next();
      //System.out.println("You typed in the color: " + color + ".");
      String food = keyboard.next();
      String animal = keyboard.next();
      int length = animal.length();
      char initial = firstName.charAt(0);
      int location = color.indexOf('e');
      String three = food.substring(0,3);
      
      
      
      System.out.printf("I had a dream that %s ate a %s %s and said it tasted like %s!\n", firstName, color, animal, food);
      
      System.out.println("Animal length is " + length);
      System.out.println("First initial is " + initial);
      System.out.println("Location of 'e' in color is " + location);
      System.out.println("First 3 characters of food are " + three);
   
   }
}
