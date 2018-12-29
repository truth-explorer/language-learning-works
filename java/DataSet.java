import ptolemy.plot.Plot;
/** Class to represent a collection of 2D point values: (x,y) pairs.
*/
public class DataSet {

   /** A shared class variable used to generate sequential IDs. */
   private static int IDGenerator = 0;
   /** The array holding the points. */
   private Point[] points;
   /** The actual number of points stored. */
   private int numPoints;
   /** The id of this DataSet. */
   private int ID;   
   
   /** Create a dataset with the given capacity.
     * @param capacity the maximum number of points.
     */
   public DataSet(int capacity) {
      points = new Point[capacity];
      this.numPoints = 0;
      this.ID = DataSet.IDGenerator++;
      
   
   }
   
   /** Get the capacity of the dataset.
     * @return the capacity
     */
   public int capacity() {
      return points.length;
   }
   
   /** Get the size of the dataset.
     * @return how many Points are in it
     */
   public int size() {
      return this.numPoints;
   }
   
   /** Get the id of the dataset.
     * @return the id number
     */
   public int getID() {
      return this.ID;
   }
   
   /** Add a point to the dataset, if there is room.
     * @param p the point to add
     * @return true if successful, false otherwise
     */
   public boolean add(Point p) {
      if (numPoints < points.length) {
         points[numPoints++] = p;
         return true; 
      }
      else {
         return false;
      }
   }
   
   /** Add an (x, y) point to the dataset, if there is room.
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     * @return true if successful, false otherwise
     */
   public boolean add(double x, double y) {
      Point o = new Point(x,y);
      return this.add(o);                                       // HINT: call the above method
   }
   
   
   // TODO: add a method to add all the points in this dataset
   // to a Plot object parameter
   public void plot(Plot pt) {
      for (int i = 0; i < this.numPoints; i++) {
         pt.addPoint(this.ID, points[i].getX(), points[i].getY(), false);
      }
   }
   
   /** Create a string representation of the dataset,
     * formatted as ID#: [ (x1,y1) (x2,y2) ... (xn,yn) ]
     * @return the string
     */
   public String toString() {
      String s = this.ID + ": [";
      String t = "";
      for (int i = 0; i < this.numPoints; i++) {
         t = "(" + points[i].getX() + ", " + points[i].getY() + ") ";
         s = s.concat(t);
      } 
      return s;
   } 
   
   
   public static void main(String[] args) {
      DataSet data = new DataSet(10);
      Point p1 = new Point(10, 20);
      Point p2 = new Point(20, 10);
      data.add(p1);
      data.add(p2);
      for (int i = 0; i < 10; i++) {
         if (! data.add(i, i*10)) {
            System.out.println("add failed");
         }
      }
      System.out.println(data);
   }
}