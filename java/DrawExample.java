/** An example of a program that uses the SW drawing library
    to create a pop-up window containing simple graphics.
    This file requires StdDraw.java to reside in the same folder.
  */ 
public class DrawExample {

   /** Main method. 
       @param args command line arguments, ignored
   */
   public static void main(String[] args) {
      StdDraw.square(0.5, 0.25, 0.1);
      
      StdDraw.setPenRadius(0.01);
      StdDraw.point(0.1, 0.1);
      StdDraw.textLeft(0.12, 0.12, "(0.1, 0.1)");
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.point(0.1, 0.9);
      StdDraw.textLeft(0.12, 0.92, "(0.1, 0.9)");
      StdDraw.point(0.5, 0.5);
      StdDraw.textLeft(0.52, 0.52, "(0.5, 0.5)");
      
      //StdDraw.clear();
      StdDraw.setPenColor(StdDraw.BLUE);
      StdDraw.square(0.5, 0.25, 0.18);
      StdDraw.filledCircle(0.5, 0.25, 0.1);
      StdDraw.text(0.5, 0.45, "JHU Gateway Computing");
   
   }
}