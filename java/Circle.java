public class Circle{
   private Point center;
   private int radius;
   public Point getCenter() {
      return this.center;
   }
   public int getRadius() {
      return this.radius;
   }
   public Circle(Point o, int r) {
      this.center = o;
      this.radius = r;
   }
   public double getArea(){
      return Math.PI * (this.radius * this.radius);
   }
   public double getPerimeter() {
      return 2 * Math.PI * this.radius;
   }
   public boolean isContained(Circle c1, Circle c2) {
      double d = Math.pow(c2.getCenter().getX() - c1.getCenter().getX(), 2) +
                 Math.pow(c2.getCenter().getY() - c1.getCenter().getY(), 2);
     
      if (Math.sqrt(d) < Math.abs(c1.getRadius() - c2.getRadius())) {
         return true;
      }
      else {
         return false;
      }
   
   
   }           
         
}
