import java.util.Scanner;
public class Task {
   private String name;  
   public void read(Scanner scnr) {
      System.out.print("Please enter the name of the task:");
      this.name = scnr.next();
      
   }
   @Override
   public String toString() {
      return this.name;
   }
   @Override
   public boolean equals(Object o) {
      if (o instanceof Task) {
         Task t = (Task) o;
         return (this.name.equals(t.name));    
      }
      else {
         return false;
      }
   }
}