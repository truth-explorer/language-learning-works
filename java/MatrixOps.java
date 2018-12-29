/** Class for basic Matrix-related operations.
 */
public class MatrixOps {
   
   /** Multiply a matrix by a scalar.
    *  @param scalar scalar to be multiplied
    *  @param a the matrix
    *  @return the resulted matrix
    */
   public static double[][] scalarMult(double scalar, double[][] a) {
      if (a == null || a.length < 1 || a[0].length < 1)
         return a;
      double [][] b = new double[a.length][a[0].length];
          
      for (int i = 0; i < a.length; i++)
         for (int j = 0; j < a[0].length; j++)
            b[i][j] = scalar * a[i][j];
      
      return b;
   }

   /** Conduct matrix multiplication.
    *  @param a first matrix
    *  @param b second matrix
    *  @return the resulted matrix
    */
   
   public static double[][] matrixMult(double[][] a, double[][] b) {
      int m1 = a.length;
      int n1 = a[0].length;
      int m2 = b.length;
      int n2 = b[0].length;
      if (n1 != m2 || m1 != n2) 
         throw new RuntimeException("Illegal matrix dimensions.");
      double[][] c = new double[m1][n2];
      for (int i = 0; i < m1; i++)
         for (int j = 0; j < n2; j++)
            c[i][j] = dotProduct(a, b, i, j);
      return c;
   }

    /** Compute the dot product of specific row and column in two matrices.
    *  @param a the matrix taking a row from
    *  @param b the matrix taking a column from
    *  @param i the row number to use from matrix a
    *  @param j the col number to use from matrix b
    *  @return the result of dot product
    */
   public static double dotProduct(double[][] a, double[][] b, int i, int j) {
      double result = 0;
      int n = a[i].length;
      for (int k = 0; k < n; k++)
         result += a[i][k] * b[k][j];
      return result;
   }
   
   /** Conduct matrix addition.
   *  @param a first matrix
   *  @param b second matrix
   *  @return the resulted matrix
   */
   public static double[][] matrixAdd(double[][] a, double[][] b) {
      if (a == null || a.length < 1 || a[0].length < 1)
         return a;
      
      if (b == null || b.length < 1 || b[0].length < 1)
         return b;
         
      if (a.length != b.length || a[0].length != b[0].length)
         return null;   
      
      double [][]c = new double[a.length][a[0].length];
      for (int i = 0; i < a.length; i++)
         for (int j = 0; j < a[0].length; j++)
            c[i][j] = a[i][j] + b[i][j];
            
      return c; 
   }
   
   /** Compute the power of a matrix.
   *  @param a a square matrix
   *  @param n the power (greater than or equal to 1 )   
   *  @return  the resulted matrix
   */
   public static double[][] power(double[][] a, int n) {
      if (a == null || a.length < 1 || a[0].length < 1)
         return a;
      if (a.length != a[0].length || n < 1)
         return null;
      if (n == 1)
         return a;
            
      double[][] b = new double[a.length][a[0].length]; 
      
      for (int i = 0; i < a.length; i++)
         for (int j = 0; j < a[0].length; j++)
            b[i][j] = a[i][j];
            
      for (int i = 2; i <= n; i++) {
         b = matrixMult(b, a);
      }
      return b;
   }
   
   /** print a Matrix.
   *  @param a matrix to be printed
   */

   public static void print(double[][] a) {
      if (a == null || a[0] == null) {
         return;
      }
      for (int i = 0; i < a.length; i++) { 
         for (int j = 0; j < a[0].length; j++) {
            System.out.printf("%8.4f ", a[i][j]);
         }
         System.out.println();   
      }   
   } 
   
   /** Fill a Matrix with n elements from 1 to n increasing order.
   *  @param a matrix to be filled
   */
   public static void fill(double[][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[0].length; j++) {
            a[i][j] = (i * a[0].length) + j + 1;
         }
      }
   }
   
   /** Driver for the Matrix class to call different operations.
   *  @param args not used
   */
   public static void main(String[] args) {
      double[][] arr1 = new double[5][3];
      double[][] arr2 = new double[3][5];
      
      double[][] vector1 = new double[1][5]; //used for dot product
      double[][] vector2 = new double[5][1]; //used for dot product
      
      
      fill(arr1);
      fill(arr2);
      print(arr1);
      System.out.println();
      print(arr2);
      System.out.println();
      
      fill(vector1);
      fill(vector2);
      
      System.out.println("multiplied:");
      print(matrixMult(arr1, arr2));
             
   }

}

