import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**Project 4 B driver.
 * To be used for accessing all the other classes' features
 */
public class Proj4B {
   private final static int GYM_CAPACITY = 500; 
   private static Member[] gym =  new Member[GYM_CAPACITY]; //list of members
   private static int gymSize = 0; // number of members
	
   public static void main(String[] args) throws FileNotFoundException {
        
      Scanner keyboard = new Scanner(System.in);
        
      int choice;
        
      do {
         String fileName = "";
         Scanner inFS = null;
         FileInputStream mf = null;
         int id = -1;
         int index = -1;
        	
        	// print menu
         System.out.println();
         System.out.println("0) Quit the program");
         System.out.println("1) Display all Members");
         System.out.println("2) Add members from a plain text file");
         System.out.println("3) Add workouts for members from a plain text file");
         System.out.println("4) Display member information");
         System.out.println("5) Display total calories burnt by a member");
         System.out.println("6) Display average calories burnt per workpout for a member");
         System.out.println("7) Display number of cardio vs strength workouts for a member");
         System.out.println("8) Display total distance covered by a member");
         System.out.println();
         System.out.print("enter choice by # -> ");
         choice = keyboard.nextInt();
            
         switch (choice) {
                    // case 0 quit program
            case 0:
               break;
                    // case 1 show all members
            case 1:
               for (int i = 0; i < gymSize; ++i) {
                  System.out.println(gym[i].toString());
               }
               break;
                    // case 2 read a member file and add them to gym
            case 2:
               System.out.print("Enter file name: ");
               fileName = keyboard.next();
               mf = new FileInputStream(fileName);
               inFS = new Scanner(mf);
               while (inFS.hasNextLine()) {
                  String phone = inFS.next();
                  String first = inFS.next();
                  String last = inFS.next();
                  gym[gymSize++] = new Member(first + " " + last, phone);		
               }
               System.out.println("Total of " + gymSize + " members successfully were added!");	
               break;
                    // case 3 read a workout file and add those workouts for the corresponding gym members
            case 3:
               System.out.print("Enter file name: ");
               int w = 0;
               fileName = keyboard.next();
               mf = new FileInputStream(fileName);
               inFS = new Scanner(mf);
               while (inFS.hasNextLine()) {
                  id = inFS.nextInt();
                  index = getMemberIndexByID(id);
                  if (index == -1) { // no such member with this id 
                     inFS.nextLine();
                     continue;
                  }
                  String type = inFS.next();
                  if (type.equalsIgnoreCase("cardio") || type.equalsIgnoreCase("strength")) {
                     int duration = inFS.nextInt();
                     gym[index].addWorkout(new Workout(duration, type));
                     w++;
                  }
                  else if (type.equalsIgnoreCase("bike")) {
                     int duration = inFS.nextInt();
                     int resistance = inFS.nextInt();
                     gym[index].addWorkout(new Bike(duration, resistance));
                     w++;
                  }
                  else if (type.equalsIgnoreCase("yoga")) {
                     int duration = inFS.nextInt();
                     String level = inFS.next();
                     int l = -1;
                     if (level.equalsIgnoreCase("basic")) {
                        l = 1;
                     }
                     else if (level.equalsIgnoreCase("intermediate")) {
                        l = 2;
                     }
                     else if (level.equalsIgnoreCase("advanced")) {
                        l = 3;
                     }
                     if (l != -1) {
                        gym[index].addWorkout(new Yoga(duration, l));
                        w++;
                     }
                  }
                  else if (type.equalsIgnoreCase("elliptical")) {
                     String eFileName = inFS.next();
                     Elliptical e = new Elliptical(eFileName);
                     gym[index].addWorkout(e);
                     w++;
                  }
               }
               System.out.println("Total of " + w + " workouts successfully were added!");
               break;
                    // case 4 print a member
            case 4:
               System.out.print("Enter member ID: ");
               id = keyboard.nextInt();
               if (id >= 100) {
                  index = getMemberIndexByID(id);
                  if (index > -1) {
                     Member m = gym[index];
                     System.out.println(m);
                  }
               }
                		
               break;
                    // case 5 total calories
            case 5:
               System.out.print("Enter member ID: ");
               id = keyboard.nextInt();
               if (id >= 100) {
                  index = getMemberIndexByID(id);
                  if (index > -1) {
                     Member m = gym[index];
                     System.out.println("Total calories for member #" + m.getID() + " = " + m.totalCalories());
                  }
               }
                		
               break;
                    // case 6 average calories
            case 6:
               System.out.print("Enter member ID: ");
               id = keyboard.nextInt();
               if (id >= 100) {
                  index = getMemberIndexByID(id);
                  if (index > -1) {
                     Member m = gym[index];
                     System.out.print("Average calories for member #" + m.getID() + " = " + m.avgCalories());
                  }
               }
                	
               break;
                	// case 7 number of cardio vs strenght for a member
            case 7:
               System.out.print("Enter member ID: ");
               id = keyboard.nextInt();
               if (id >= 100) {
                  index = getMemberIndexByID(id);
                  if (index > -1) {
                     Member m = gym[index];
                     System.out.println("Number of cardio vs strength workouts for member #" + m.getID() + " : " + m.numCardio() + " vs " + m.numStrength());
                  }
               }
               break;
                	// case 8 total distance
            case 8:
               System.out.print("Enter member ID: ");
               id = keyboard.nextInt();
               if (id >= 100) {
                  index = getMemberIndexByID(id);
                  if (index > -1) {
                     Member m = gym[index];
                     System.out.print("Total distance covered by member #" + m.getID() + " = " + m.totalDistanceCovered());
                  }
               }
               break;
            default:
               System.out.println("invalid choice number");
         }
         if (inFS != null) inFS.close(); // close resources
      } 
        while (choice != 0);
      keyboard.close(); // close resources
        
   }
    
    // find the index of a member in the gym array by his/her ID number
   private static int getMemberIndexByID (int id) {
      for (int i = 0; i < gymSize; i++) {
         if (gym[i].getID() == id) {
            return i;
         }
      }
      return -1;
   }
}