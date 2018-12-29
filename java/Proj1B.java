import java.util.Scanner;
/** Love Art, Shuchen Zhang, szhan106, 09/16/2018.
*/
public class Proj1B {
   /** Main method. 
       @param args command line arguments, ignored
      */
   public static void main(String[] args) {
      int length = 0;
      double space = 0.0;
      double widthShapes = 0.0;
      final int numShapes = 4;
      Scanner scnr = new Scanner(System.in);
      System.out.println("Please enter" + 
         "the overall length of the entire graphic:");
      length = scnr.nextInt();
      System.out.println("Please enter amount of" +
         "horizontal spacing between the four shapes:");
      space = scnr.nextDouble();
      widthShapes = (length - 7 * space) / numShapes;
      StdDraw.setCanvasSize(length, length);
      StdDraw.setScale(0.001, length);
      StdDraw.setPenRadius(0.0);
      StdDraw.setPenColor(StdDraw.YELLOW);
      double xCenRec = space * 2 + widthShapes / 2;
      double xCenCir = xCenRec + space + widthShapes;
      double xCenTri = xCenCir + space + widthShapes;
      double xCenSqu = xCenTri + space + widthShapes;
      double yCen = length / 2;
      StdDraw.filledRectangle(xCenRec, yCen, 
          widthShapes / 3, widthShapes / 2);
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.filledCircle(xCenCir, yCen, widthShapes / 2);
      StdDraw.setPenColor(StdDraw.GREEN);
      double[] x = {xCenTri, xCenTri - widthShapes / 2, 
                    xCenTri + widthShapes / 2 };
      double[] y = {yCen - widthShapes  / 2, 
                    yCen + widthShapes / 2, yCen + widthShapes / 2 };
      StdDraw.filledPolygon(x, y);  
      StdDraw.setPenColor(StdDraw.BLUE);
      StdDraw.filledSquare(xCenSqu, yCen, widthShapes / 2);
      
      
      
      
      
      
      
      
      
   }
}