import java.awt.Color;

class PictureOps {
   
   public static int applyContrast (int r, double factor) {
      r = (int) ((r - 128) * factor);
      if (r > 255) {
         r = 255;
      }
      if (r < 0) {
         r = 0;
      }
      
      return r;
   }
   public static Picture contrast (Picture picture, double factor) {
      Color color = null;
      int red, green, blue;
      for (int r = 0; r < picture.height(); r++) {
         for (int c = 0; c < picture.width(); c++) {
            color = picture.get(c,r);
            red = color.getRed();
            blue = color.getBlue();
            green = color.getGreen();
            red = applyContrast(red, factor);
            blue = applyContrast(blue, factor);
            green = applyContrast(green, factor);
            Color newColor = new Color(red, green, blue);
            picture.set(c, r, newColor);
            
          
         }
      }
      return picture;
   }
   
   public static Picture grayScale(Picture picture) {
      Color color = null;
      int red, green, blue;
      for (int r = 0; r < picture.height(); r++) {
         for (int c = 0; c < picture.width(); c++) {
            color = picture.get(c,r);
            red = color.getRed();
            blue = color.getBlue();
            green = color.getGreen();
            int intensity = (int) (0.3 * red + 0.59 * green + 0.11 * blue);
            Color newColor = new Color(intensity, intensity, intensity);
            picture.set(c, r, newColor);
            
          
         }
      } 
     
      return picture;
   
   }
   
   public static Picture swap(Picture picture) {
      Color color = null;
      int red, green, blue;
      for (int r = 0; r < picture.height(); r++) {
         for (int c = 0; c < picture.width(); c++) {
            color = picture.get(c,r);
            red = color.getRed();
            blue = color.getBlue();
            green = color.getGreen();
            Color newColor = new Color(green, blue, red);
            picture.set(c, r, newColor);
            
          
         }
      } 
     
      return picture;
   }
     
   /* Picture operations  
    *
    * @param args the command-line arguments
    */
   public static void main(String[] args) {
      Picture picture = new Picture("shiraz.jpg");
      // uncomment each of the following operations one at a time to see the result
      
      contrast(picture, 0.5);
      //swap(picture);
      //swap(swap(picture));
      //grayScale(picture);
      
      picture.show();
   }
}